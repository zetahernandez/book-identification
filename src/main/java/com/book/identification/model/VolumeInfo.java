package com.book.identification.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * General volume information.
 */
@Entity
@XmlRootElement(name="volume_info")
public final class VolumeInfo extends EntityBase {
	/**
	 * The names of the authors and/or editors for this volume. (In LITE
	 * projection) The value may be {@code null}.
	 */
	@ElementCollection(fetch = FetchType.LAZY)
	private java.util.Set<String> authors;

	/**
	 * The mean review rating for this volume. (min = 1.0, max = 5.0) The value
	 * may be {@code null}.
	 */

	private Double averageRating;

	/**
	 * Canonical URL for a volume. (In LITE projection.) The value may be
	 * {@code null}.
	 */

	private String canonicalVolumeLink;

	/**
	 * A list of subject categories, such as "Fiction", "Suspense", etc. The
	 * value may be {@code null}.
	 */
	@ElementCollection(fetch = FetchType.LAZY)
	private java.util.Set<String> categories;

	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<Category> categoriess;
	
	@XmlElement(name="categories")
	public Set<Category> getCategoriess() {
		return categoriess;
	}

	public void setCategoriess(Set<Category> categoriess) {
		this.categoriess = categoriess;
	}

	/**
	 * An identifier for the version of the volume content (text & images). (In
	 * LITE projection) The value may be {@code null}.
	 */

	private String contentVersion;

	/**
	 * A synopsis of the volume. The text of the description is formatted in
	 * HTML and includes simple formatting elements, such as b, i, and br tags.
	 * (In LITE projection.) The value may be {@code null}.
	 */
	@Lob
	private String description;

	/**
	 * Physical dimensions of this volume. The value may be {@code null}.
	 */
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Dimensions dimensions;

	/**
	 * A list of image links for all the sizes that are available. (In LITE
	 * projection.) The value may be {@code null}.
	 */
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private ImageLinks imageLinks;

	/**
	 * Industry standard identifiers for this volume. The value may be
	 * {@code null}.
	 */
	@OneToMany(orphanRemoval = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private java.util.List<IndustryIdentifiers> industryIdentifiers;

	static {
		// hack to force ProGuard to consider IndustryIdentifiers used, since
		// otherwise it would be stripped out
		// see
		// http://code.google.com/p/google-api-java-client/issues/detail?id=528
		com.google.api.client.util.Data.nullOf(IndustryIdentifiers.class);
	}

	/**
	 * URL to view information about this volume on the Google Books site. (In
	 * LITE projection) The value may be {@code null}.
	 */

	private String infoLink;

	/**
	 * Best language for this volume (based on content). It is the two-letter
	 * ISO 639-1 code such as 'fr', 'en', etc. The value may be {@code null}.
	 */

	private String language;

	/**
	 * The main category to which this volume belongs. It will be the category
	 * from the categories list returned below that has the highest weight. The
	 * value may be {@code null}.
	 */

	private String mainCategory;

	/**
	 * Total number of pages. The value may be {@code null}.
	 */

	private Integer pageCount;

	/**
	 * URL to preview this volume on the Google Books site. The value may be
	 * {@code null}.
	 */

	private String previewLink;

	/**
	 * Type of publication of this volume. Possible values are BOOK or MAGAZINE.
	 * The value may be {@code null}.
	 */

	private String printType;

	/**
	 * Date of publication. (In LITE projection.) The value may be {@code null}.
	 */

	private String publishedDate;

	/**
	 * Publisher of this volume. (In LITE projection.) The value may be
	 * {@code null}.
	 */

	private String publisher;

	/**
	 * The number of review ratings for this volume. The value may be
	 * {@code null}.
	 */

	private Integer ratingsCount;

	/**
	 * Volume subtitle. (In LITE projection.) The value may be {@code null}.
	 */

	private String subtitle;

	/**
	 * Volume title. (In LITE projection.) The value may be {@code null}.
	 */

	private String title;

	/**
	 * The names of the authors and/or editors for this volume. (In LITE
	 * projection) The value returned may be {@code null}.
	 */
	public java.util.Set<String> getAuthors() {
		return authors;
	}

	/**
	 * The names of the authors and/or editors for this volume. (In LITE
	 * projection) The value set may be {@code null}.
	 */
	
	public void setAuthors(java.util.Set<String> authors) {
		this.authors = authors;

	}

	/**
	 * The mean review rating for this volume. (min = 1.0, max = 5.0) The value
	 * returned may be {@code null}.
	 */
	@XmlTransient
	public Double getAverageRating() {
		return averageRating;
	}

	/**
	 * The mean review rating for this volume. (min = 1.0, max = 5.0) The value
	 * set may be {@code null}.
	 */
	public void setAverageRating(Double averageRating) {
		this.averageRating = averageRating;

	}

	/**
	 * Canonical URL for a volume. (In LITE projection.) The value returned may
	 * be {@code null}.
	 */
	@XmlTransient
	public String getCanonicalVolumeLink() {
		return canonicalVolumeLink;
	}

	/**
	 * Canonical URL for a volume. (In LITE projection.) The value set may be
	 * {@code null}.
	 */
	
	public void setCanonicalVolumeLink(String canonicalVolumeLink) {
		this.canonicalVolumeLink = canonicalVolumeLink;

	}

	/**
	 * A list of subject categories, such as "Fiction", "Suspense", etc. The
	 * value returned may be {@code null}.
	 */
	@XmlTransient
	public java.util.Set<String> getCategories() {
		return categories;
	}

	/**
	 * A list of subject categories, such as "Fiction", "Suspense", etc. The
	 * value set may be {@code null}.
	 */
	public void setCategories(java.util.Set<String> categories) {
		this.categories = categories;
	}

	/**
	 * An identifier for the version of the volume content (text & images). (In
	 * LITE projection) The value returned may be {@code null}.
	 */
	@XmlTransient
	public String getContentVersion() {
		return contentVersion;
	}

	/**
	 * An identifier for the version of the volume content (text & images). (In
	 * LITE projection) The value set may be {@code null}.
	 */
	public void setContentVersion(String contentVersion) {
		this.contentVersion = contentVersion;

	}

	/**
	 * A synopsis of the volume. The text of the description is formatted in
	 * HTML and includes simple formatting elements, such as b, i, and br tags.
	 * (In LITE projection.) The value returned may be {@code null}.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * A synopsis of the volume. The text of the description is formatted in
	 * HTML and includes simple formatting elements, such as b, i, and br tags.
	 * (In LITE projection.) The value set may be {@code null}.
	 */
	public void setDescription(String description) {
		this.description = description;

	}

	/**
	 * Physical dimensions of this volume. The value returned may be
	 * {@code null}.
	 */
	@XmlTransient
	public Dimensions getDimensions() {
		return dimensions;
	}

	/**
	 * Physical dimensions of this volume. The value set may be {@code null}.
	 */
	public void setDimensions(Dimensions dimensions) {
		this.dimensions = dimensions;

	}

	/**
	 * A list of image links for all the sizes that are available. (In LITE
	 * projection.) The value returned may be {@code null}.
	 */
	@XmlElement(name="image_links")
	public ImageLinks getImageLinks() {
		return imageLinks;
	}

	/**
	 * A list of image links for all the sizes that are available. (In LITE
	 * projection.) The value set may be {@code null}.
	 */
	public void setImageLinks(ImageLinks imageLinks) {
		this.imageLinks = imageLinks;

	}

	/**
	 * Industry standard identifiers for this volume. The value returned may be
	 * {@code null}.
	 */
	@XmlElement(name="industry_identifiers")
	public java.util.List<IndustryIdentifiers> getIndustryIdentifiers() {
		return industryIdentifiers;
	}

	/**
	 * Industry standard identifiers for this volume. The value set may be
	 * {@code null}.
	 */
	public void setIndustryIdentifiers(
			java.util.List<IndustryIdentifiers> industryIdentifiers) {
		this.industryIdentifiers = industryIdentifiers;

	}

	/**
	 * URL to view information about this volume on the Google Books site. (In
	 * LITE projection) The value returned may be {@code null}.
	 */
	@XmlTransient	
	public String getInfoLink() {
		return infoLink;
	}

	/**
	 * URL to view information about this volume on the Google Books site. (In
	 * LITE projection) The value set may be {@code null}.
	 */
	public void setInfoLink(String infoLink) {
		this.infoLink = infoLink;

	}

	/**
	 * Best language for this volume (based on content). It is the two-letter
	 * ISO 639-1 code such as 'fr', 'en', etc. The value returned may be
	 * {@code null}.
	 */
	@XmlTransient
	public String getLanguage() {
		return language;
	}

	/**
	 * Best language for this volume (based on content). It is the two-letter
	 * ISO 639-1 code such as 'fr', 'en', etc. The value set may be {@code null}
	 * .
	 */
	public void setLanguage(String language) {
		this.language = language;

	}

	/**
	 * The main category to which this volume belongs. It will be the category
	 * from the categories list returned below that has the highest weight. The
	 * value returned may be {@code null}.
	 */
	@XmlTransient
	public String getMainCategory() {
		return mainCategory;
	}

	/**
	 * The main category to which this volume belongs. It will be the category
	 * from the categories list returned below that has the highest weight. The
	 * value set may be {@code null}.
	 */
	public void setMainCategory(String mainCategory) {
		this.mainCategory = mainCategory;

	}

	/**
	 * Total number of pages. The value returned may be {@code null}.
	 */
	@XmlElement(name="pages")
	public Integer getPageCount() {
		return pageCount;
	}

	/**
	 * Total number of pages. The value set may be {@code null}.
	 */
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;

	}

	/**
	 * URL to preview this volume on the Google Books site. The value returned
	 * may be {@code null}.
	 */
	@XmlTransient
	public String getPreviewLink() {
		return previewLink;
	}

	/**
	 * URL to preview this volume on the Google Books site. The value set may be
	 * {@code null}.
	 */
	public void setPreviewLink(String previewLink) {
		this.previewLink = previewLink;

	}

	/**
	 * Type of publication of this volume. Possible values are BOOK or MAGAZINE.
	 * The value returned may be {@code null}.
	 */
	@XmlTransient
	public String getPrintType() {
		return printType;
	}

	/**
	 * Type of publication of this volume. Possible values are BOOK or MAGAZINE.
	 * The value set may be {@code null}.
	 */
	public void setPrintType(String printType) {
		this.printType = printType;

	}

	/**
	 * Date of publication. (In LITE projection.) The value returned may be
	 * {@code null}.
	 */
	@XmlElement(name="published_date")
	public String getPublishedDate() {
		return publishedDate;
	}

	/**
	 * Date of publication. (In LITE projection.) The value set may be
	 * {@code null}.
	 */
	public void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;

	}

	/**
	 * Publisher of this volume. (In LITE projection.) The value returned may be
	 * {@code null}.
	 */
	
	public String getPublisher() {
		return publisher;
	}

	/**
	 * Publisher of this volume. (In LITE projection.) The value set may be
	 * {@code null}.
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;

	}

	/**
	 * The number of review ratings for this volume. The value returned may be
	 * {@code null}.
	 */
	@XmlTransient
	public Integer getRatingsCount() {
		return ratingsCount;
	}

	/**
	 * The number of review ratings for this volume. The value set may be
	 * {@code null}.
	 */
	public void setRatingsCount(Integer ratingsCount) {
		this.ratingsCount = ratingsCount;

	}

	/**
	 * Volume subtitle. (In LITE projection.) The value returned may be
	 * {@code null}.
	 */
	public String getSubtitle() {
		return subtitle;
	}

	/**
	 * Volume subtitle. (In LITE projection.) The value set may be {@code null}.
	 */
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;

	}

	/**
	 * Volume title. (In LITE projection.) The value returned may be
	 * {@code null}.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Volume title. (In LITE projection.) The value set may be {@code null}.
	 */
	public void setTitle(String title) {
		this.title = title;

	}
}