package com.book.identification.model;

import javax.persistence.Entity;


/**
 * Information about pdf content. (In LITE projection.)
 */
@Entity
public final class Pdf extends EntityBase {

  /**
   * URL to retrieve ACS token for pdf download. (In LITE projection.)
   * The value may be {@code null}.
   */

  private String acsTokenLink;

  /**
   * URL to download pdf. (In LITE projection.)
   * The value may be {@code null}.
   */

  private String downloadLink;

  /**
   * Is a scanned image pdf available either as public domain or for purchase. (In LITE projection.)
   * The value may be {@code null}.
   */

  private Boolean isAvailable;

  /**
   * URL to retrieve ACS token for pdf download. (In LITE projection.)
   * The value returned may be {@code null}.
   */
  public String getAcsTokenLink() {
    return acsTokenLink;
  }

  /**
   * URL to retrieve ACS token for pdf download. (In LITE projection.)
   * The value set may be {@code null}.
   */
  public void setAcsTokenLink(String acsTokenLink) {
    this.acsTokenLink = acsTokenLink;
    
  }

  /**
   * URL to download pdf. (In LITE projection.)
   * The value returned may be {@code null}.
   */
  public String getDownloadLink() {
    return downloadLink;
  }

  /**
   * URL to download pdf. (In LITE projection.)
   * The value set may be {@code null}.
   */
  public void setDownloadLink(String downloadLink) {
    this.downloadLink = downloadLink;
    
  }

  /**
   * Is a scanned image pdf available either as public domain or for purchase. (In LITE projection.)
   * The value returned may be {@code null}.
   */
  public Boolean getIsAvailable() {
    return isAvailable;
  }

  /**
   * Is a scanned image pdf available either as public domain or for purchase. (In LITE projection.)
   * The value set may be {@code null}.
   */
  public void setIsAvailable(Boolean isAvailable) {
    this.isAvailable = isAvailable;
    
  }

@Override
public String toString() {
	return "Pdf [acsTokenLink=" + acsTokenLink + ", downloadLink="
			+ downloadLink + ", isAvailable=" + isAvailable + "]";
}

}