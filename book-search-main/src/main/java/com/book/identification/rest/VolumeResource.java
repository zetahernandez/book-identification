// Copyright 2013 fernando.hernandez

// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at

//   http://www.apache.org/licenses/LICENSE-2.0

// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.book.identification.rest;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.Query;
import org.apache.lucene.util.Version;
import org.atmosphere.annotation.Broadcast;
import org.atmosphere.annotation.Suspend;
import org.hibernate.Transaction;
import org.hibernate.search.FullTextQuery;
import org.hibernate.search.FullTextSession;

import com.book.identification.BookIdentificationWork;
import com.book.identification.dao.DAOFactory;
import com.book.identification.dao.VolumeDAO;
import com.book.identification.model.Volume;
import com.book.identification.model.collections.Volumes;
import com.book.identification.task.CreateTreeOfCategories;
import com.book.identification.util.FileHashUtil;
import com.sun.jersey.multipart.FormDataParam;

@Path("volumes/")
public class VolumeResource {

	private static final int PAGE_LENGTH = 10;

	@SuppressWarnings("unchecked")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response volumes(@QueryParam("categoryId") Long categoryId,
			@QueryParam("page") Integer page, @QueryParam("q") String q) {
		Volumes volumes = new Volumes();

		VolumeDAO volumeDAO = DAOFactory.getInstance().getVolumeDAO();
		FullTextSession fts = org.hibernate.search.Search.getFullTextSession(volumeDAO.getSession());

		try {
			Query query = buildLuceneQuery(categoryId, page, q);
			FullTextQuery createFullTextQuery = fts.createFullTextQuery(query,com.book.identification.model.Volume.class);
			addPaginationToQuery(createFullTextQuery, page);
			List<Volume> list = createFullTextQuery.list();
			for (Volume volume : list) {
				volume.setPage(page);
				volume.setQ(q);
			}
			volumes.setVolumes(createFullTextQuery.list());
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		if(volumes.getVolumes().isEmpty()){
			return Response.ok("volumes : {}").build();
		}

		return Response.ok(volumes).build();
	}

	private void addPaginationToQuery(FullTextQuery fullTextQuery, Integer page) {
		if (page != null && page > 0) {
			fullTextQuery.setFirstResult((page - 1) * PAGE_LENGTH)
					.setMaxResults(PAGE_LENGTH);
		} else {
			fullTextQuery.setFirstResult(0).setMaxResults(PAGE_LENGTH);
		}
	}

	private Query buildLuceneQuery(Long categoryId, Integer page, String q)
			throws ParseException {
		StringBuilder query = new StringBuilder();
		
		QueryParser queryParser = new org.apache.lucene.queryParser.QueryParser(
				Version.LUCENE_31, "title", new StandardAnalyzer((Version.LUCENE_31)));
		if (StringUtils.isNotBlank(q)) {
			query.append(buildQuery(q));
		}
		
		if (categoryId != null) {
			List<Long> childCategories = DAOFactory.getInstance().getCategoryDAO().childCategories(categoryId);
			if(StringUtils.isNotBlank(q)){
				query.append("AND ( " + buildQuery(childCategories) + ")" );
			}else{
				query.append(buildQuery(childCategories));
			}
				
			buildQuery(childCategories);
	
		}
		if (!StringUtils.isNotBlank(query)) {
			query.append("id:*");
		}
		queryParser.setAllowLeadingWildcard(true);
		return queryParser.parse(query.toString());
	}

	
	private String buildQuery( List<Long> ids) {
		StringBuilder stringBuilder = new StringBuilder();
		for (Long id : ids) {
			stringBuilder.append("volumeInfo.categoriess.entityId: " + id.toString() + " ");
		}
		return stringBuilder.toString();
	}

	private String buildQuery(String q) {
		String query = null;
		String[] words = q.split(" ");
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			query = "volumeInfo.title: " + word
					+ " volumeInfo.description: " + word + " ";
		}
		return query;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("searchVolumes/")
	public Response searchVolumes(@QueryParam("directory") String directory) {

		BookIdentificationWork bookIdentificationWork = new BookIdentificationWork(
				"BookIdentificationWork", new String[] { directory });
		bookIdentificationWork.start();
		return Response.ok("indexing").build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("reindex/")
	public Response reindex() {
		VolumeDAO volumeDAO = DAOFactory.getInstance().getVolumeDAO();
		FullTextSession fts = org.hibernate.search.Search.getFullTextSession(volumeDAO.getSession());
		try {
			fts.createIndexer().startAndWait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return Response.ok("reindex").build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("createCategories/")
	public Response createCategories() {
		new CreateTreeOfCategories().execute();
		return Response.ok("createCategories").build();
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("hash/")
	public Response hashing() {
		VolumeDAO volumeDAO = DAOFactory.getInstance().getVolumeDAO();
		List<Volume> findAll = volumeDAO.findAll();
		Transaction beginTransaction = volumeDAO.getSession().beginTransaction();
		for (Volume volume : findAll) {
			String fileSHA1 = FileHashUtil.getFileSHA1(new File(volume.getPath()));
			volume.setHashSH1(fileSHA1);
		}
		beginTransaction.commit();
		return Response.ok("hashed").build();
	}

	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("upload/")
	public Response upload(@FormDataParam("fileName") String filename,@FormDataParam("file") InputStream inputStream ) {
		
		String path;
		try {
			path = new File(".").getCanonicalPath() + File.separatorChar + "books" + File.separatorChar + filename;
			FileUtils.copyInputStreamToFile(inputStream, new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return Response.ok("").build();
	}
	@GET
	@Suspend
    @Produces(MediaType.APPLICATION_JSON)
	@Path("chat/")
	public Response chat() {
		
		String path;
		

		return Response.ok("").build();
	}
	/**
     * Broadcast the received message object to all suspended response. Do not write back the message to the calling connection.
     * @param message
     * @return a {@link Response}
     */
    @Broadcast(writeEntity = false)
    @Produces(MediaType.APPLICATION_JSON)
    @POST
	@Path("chat/")
    public Response broadcast() {
        return Response.ok("").build();
    }
}
