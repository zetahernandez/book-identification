package com.book.identification.model;

import javax.persistence.Entity;


/**
 * Information about epub content. (In LITE projection.)
 */
@Entity
public final class Epub extends EntityBase {

  /**
   * URL to retrieve ACS token for epub download. (In LITE projection.)
   * The value may be {@code null}.
   */

  private String acsTokenLink;

  /**
   * URL to download epub. (In LITE projection.)
   * The value may be {@code null}.
   */

  private String downloadLink;

  /**
   * Is a flowing text epub available either as public domain or for purchase. (In LITE projection.)
   * The value may be {@code null}.
   */

  private Boolean isAvailable;

  /**
   * URL to retrieve ACS token for epub download. (In LITE projection.)
   * The value returned may be {@code null}.
   */
  public String getAcsTokenLink() {
    return acsTokenLink;
  }

  /**
   * URL to retrieve ACS token for epub download. (In LITE projection.)
   * The value set may be {@code null}.
   */
  public void setAcsTokenLink(String acsTokenLink) {
    this.acsTokenLink = acsTokenLink;
    
  }

  /**
   * URL to download epub. (In LITE projection.)
   * The value returned may be {@code null}.
   */
  public String getDownloadLink() {
    return downloadLink;
  }

  /**
   * URL to download epub. (In LITE projection.)
   * The value set may be {@code null}.
   */
  public void setDownloadLink(String downloadLink) {
    this.downloadLink = downloadLink;
    
  }

  /**
   * Is a flowing text epub available either as public domain or for purchase. (In LITE projection.)
   * The value returned may be {@code null}.
   */
  public Boolean getIsAvailable() {
    return isAvailable;
  }

  /**
   * Is a flowing text epub available either as public domain or for purchase. (In LITE projection.)
   * The value set may be {@code null}.
   */
  public void setIsAvailable(Boolean isAvailable) {
    this.isAvailable = isAvailable;
    
  }

@Override
public String toString() {
	return "Epub [acsTokenLink=" + acsTokenLink + ", downloadLink="
			+ downloadLink + ", isAvailable=" + isAvailable + "]";
}

}