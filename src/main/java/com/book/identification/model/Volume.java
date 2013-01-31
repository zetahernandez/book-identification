package com.book.identification.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;
import org.hibernate.search.annotations.Store;

import com.book.identification.task.base.ItemQueue;

/*
 * Copyright 2010 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
/*
 * Warning! This file is generated. Modify at your own risk.
 */

/**
 * Model definition for Volume.
 * 
 * <p>
 * This is the Java data model class that specifies how to parse/serialize into
 * the JSON that is transmitted over HTTP when working with the Books API. For a
 * detailed explanation see: <a
 * href="http://code.google.com/p/google-api-java-client/wiki/Json"
 * >http://code.google.com/p/google-api-java-client/wiki/Json</a>
 * </p>
 * 
 * <p>
 * Upgrade warning: starting with version 1.12 {@code getResponseHeaders()} is
 * removed, instead use
 * {@link com.google.api.client.http.json.JsonHttpRequest#getLastResponseHeaders()}
 * </p>
 * 
 * @author Google, Inc.
 */
@Indexed
@Entity
@XmlRootElement(name="volume")
public final class Volume extends EntityBase implements ItemQueue {

	/**
	 * Any information about a volume related to reading or obtaining that
	 * volume text. This information can depend on country (books may be public
	 * domain in one country but not in another, e.g.). The value may be
	 * {@code null}.
	 */
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private AccessInfo accessInfo;

	/**
	 * Opaque identifier for a specific version of a volume resource. (In LITE
	 * projection) The value may be {@code null}.
	 */
	private String etag;

	/**
	 * Unique identifier for a volume. (In LITE projection.) The value may be
	 * {@code null}.
	 */
	@Field
	private String id;

	/**
	 * Resource type for a volume. (In LITE projection.) The value may be
	 * {@code null}.
	 */
	@Field
	private String kind;

	/**
	 * Recommendation related information for this volume. The value may be
	 * {@code null}.
	 */
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private RecommendedInfo recommendedInfo;

	/**
	 * Any information about a volume related to the eBookstore and/or
	 * purchaseability. This information can depend on the country where the
	 * request originates from (i.e. books may not be for sale in certain
	 * countries). The value may be {@code null}.
	 */
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private SaleInfo saleInfo;

	/**
	 * Search result information related to this volume. The value may be
	 * {@code null}.
	 */
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private SearchInfo searchInfo;

	/**
	 * URL to this resource. (In LITE projection.) The value may be {@code null}
	 * .
	 */
	private String selfLink;

	/**
	 * User specific information related to this volume. (e.g. page this user
	 * last read or whether they purchased this book) The value may be
	 * {@code null}.
	 */
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private UserInfo userInfo;
	
	@Field(index = Index.YES,store=Store.YES)
	private String hashSH1;
	
	
	@Column
	public String getHashSH1() {
		return hashSH1;
	}

	public void setHashSH1(String hashSH1) {
		this.hashSH1 = hashSH1;
	}

	/**
	 * General volume information. The value may be {@code null}.
	 */
	@IndexedEmbedded
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private VolumeInfo volumeInfo;

	/**
	 * Any information about a volume related to reading or obtaining that
	 * volume text. This information can depend on country (books may be public
	 * domain in one country but not in another, e.g.). The value returned may
	 * be {@code null}.
	 */
	@XmlTransient
	public AccessInfo getAccessInfo() {
		return accessInfo;
	}

	/**
	 * Any information about a volume related to reading or obtaining that
	 * volume text. This information can depend on country (books may be public
	 * domain in one country but not in another, e.g.). The value set may be
	 * {@code null}.
	 */
	public void setAccessInfo(AccessInfo accessInfo) {
		this.accessInfo = accessInfo;

	}

	/**
	 * Opaque identifier for a specific version of a volume resource. (In LITE
	 * projection) The value returned may be {@code null}.
	 */
	@XmlTransient
	public String getEtag() {
		return etag;
	}

	/**
	 * Opaque identifier for a specific version of a volume resource. (In LITE
	 * projection) The value set may be {@code null}.
	 */
	public void setEtag(String etag) {
		this.etag = etag;

	}

	/**
	 * Unique identifier for a volume. (In LITE projection.) The value returned
	 * may be {@code null}.
	 */
	@XmlElement(name="book_id")
	public String getId() {
		return id;
	}

	/**
	 * Unique identifier for a volume. (In LITE projection.) The value set may
	 * be {@code null}.
	 */
	public void setId(String volumeId) {
		this.id = volumeId;

	}

	/**
	 * Resource type for a volume. (In LITE projection.) The value returned may
	 * be {@code null}.
	 */
	
	public String getKind() {
		return kind;
	}

	/**
	 * Resource type for a volume. (In LITE projection.) The value set may be
	 * {@code null}.
	 */
	public void setKind(String kind) {
		this.kind = kind;

	}

	/**
	 * Recommendation related information for this volume. The value returned
	 * may be {@code null}.
	 */
	@XmlTransient
	public RecommendedInfo getRecommendedInfo() {
		return recommendedInfo;
	}

	/**
	 * Recommendation related information for this volume. The value set may be
	 * {@code null}.
	 */
	public void setRecommendedInfo(RecommendedInfo recommendedInfo) {
		this.recommendedInfo = recommendedInfo;

	}

	/**
	 * Any information about a volume related to the eBookstore and/or
	 * purchaseability. This information can depend on the country where the
	 * request originates from (i.e. books may not be for sale in certain
	 * countries). The value returned may be {@code null}.
	 */
	@XmlTransient
	public SaleInfo getSaleInfo() {
		return saleInfo;
	}

	/**
	 * Any information about a volume related to the eBookstore and/or
	 * purchaseability. This information can depend on the country where the
	 * request originates from (i.e. books may not be for sale in certain
	 * countries). The value set may be {@code null}.
	 */
	public void setSaleInfo(SaleInfo saleInfo) {
		this.saleInfo = saleInfo;

	}

	/**
	 * Search result information related to this volume. The value returned may
	 * be {@code null}.
	 */
	@XmlTransient
	public SearchInfo getSearchInfo() {
		return searchInfo;
	}

	/**
	 * Search result information related to this volume. The value set may be
	 * {@code null}.
	 */
	public void setSearchInfo(SearchInfo searchInfo) {
		this.searchInfo = searchInfo;

	}

	/**
	 * URL to this resource. (In LITE projection.) The value returned may be
	 * {@code null}.
	 */
	@XmlTransient
	public String getSelfLink() {
		return selfLink;
	}

	/**
	 * URL to this resource. (In LITE projection.) The value set may be
	 * {@code null}.
	 */
	public void setSelfLink(String selfLink) {
		this.selfLink = selfLink;

	}

	/**
	 * User specific information related to this volume. (e.g. page this user
	 * last read or whether they purchased this book) The value returned may be
	 * {@code null}.
	 */
	@XmlTransient
	public UserInfo getUserInfo() {
		return userInfo;
	}

	/**
	 * User specific information related to this volume. (e.g. page this user
	 * last read or whether they purchased this book) The value set may be
	 * {@code null}.
	 */
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;

	}

	/**
	 * General volume information. The value returned may be {@code null}.
	 */
	@XmlElement(name="volume_info")
	public VolumeInfo getVolumeInfo() {
		return volumeInfo;
	}

	/**
	 * General volume information. The value set may be {@code null}.
	 */
	public void setVolumeInfo(VolumeInfo volumeInfo) {
		this.volumeInfo = volumeInfo;
	}

	@Override
	public String toString() {
		return "Volume [accessInfo=" + accessInfo + ", etag=" + etag + ", id="
				+ id + ", kind=" + kind + ", recommendedInfo="
				+ recommendedInfo + ", saleInfo=" + saleInfo + ", searchInfo="
				+ searchInfo + ", selfLink=" + selfLink + ", userInfo="
				+ userInfo + ", volumeInfo=" + volumeInfo + "]";
	}

	private String path;
	
	private String fileName;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	@XmlTransient
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
		
}
