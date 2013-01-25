package com.book.identification;

import java.awt.Desktop;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.Query;
import org.apache.lucene.util.Version;
import org.hibernate.search.FullTextSession;

import com.book.identification.dao.DAOFactory;
import com.book.identification.dao.VolumeInfoDAO;
import com.book.identification.httpserver.JettyHttpServer;
import com.book.identification.model.VolumeInfo;


public class Main {

	private static Logger logger = LogManager.getLogger(Main.class);
	/**
	 * @param args	 */
	public static void main(String[] args) {
		JettyHttpServer httpServer = new JettyHttpServer();
		httpServer.start();
//		
		HibernateUtil.getSessionFactory();
//////		
//		BookIdentificationWork bookIdentificationWork = new BookIdentificationWork("BookIdentificationWork",args);  
//		bookIdentificationWork.start();
//		try {
//			bookIdentificationWork.join();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		VolumeInfoDAO volumeInfoDAO = DAOFactory.getInstance().getVolumeInfoDAO();
//		FullTextSession fts = org.hibernate.search.Search.getFullTextSession( volumeInfoDAO.getSession());
//		
//		QueryParser queryParser = new org.apache.lucene.queryParser.QueryParser(Version.LUCENE_31,"title",new StandardAnalyzer((Version.LUCENE_31)));
//		try {
//			Query query = queryParser.parse("title:javascript");
//			fts.createFullTextQuery(query, VolumeInfo.class);
//		} catch (ParseException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		fts.close();
////	
////		
//		new CreateTreeOfCategories().execute();
//		
		try {
			InetAddress localHost = InetAddress.getLocalHost();
			URI uri = new java.net.URI( "http://"+localHost.getHostName()+":8080" );
			Desktop.getDesktop().browse( uri );
		} catch (IOException e) {
			logger.error(e);
		} catch (URISyntaxException e) {
			logger.error(e);
		}
		
	}
	
}
