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

package com.book.identification.model;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * A list of image links for all the sizes that are available. (In LITE projection.)
 */
@Entity
@XmlRootElement(name="image_links")
public final class ImageLinks  extends EntityBase {

  /**
   * Image link for extra large size (width of ~1280 pixels). (In LITE projection)
   * The value may be {@code null}.
   */

  private String extraLarge;

  /**
   * Image link for large size (width of ~800 pixels). (In LITE projection)
   * The value may be {@code null}.
   */

  private String large;

  /**
   * Image link for medium size (width of ~575 pixels). (In LITE projection)
   * The value may be {@code null}.
   */

  private String medium;

  /**
   * Image link for small size (width of ~300 pixels). (In LITE projection)
   * The value may be {@code null}.
   */

  private String small;

  /**
   * Image link for small thumbnail size (width of ~80 pixels). (In LITE projection)
   * The value may be {@code null}.
   */

  private String smallThumbnail;

  /**
   * Image link for thumbnail size (width of ~128 pixels). (In LITE projection)
   * The value may be {@code null}.
   */

  private String thumbnail;

  /**
   * Image link for extra large size (width of ~1280 pixels). (In LITE projection)
   * The value returned may be {@code null}.
   */
  public String getExtraLarge() {
    return extraLarge;
  }

  /**
   * Image link for extra large size (width of ~1280 pixels). (In LITE projection)
   * The value set may be {@code null}.
   */
  public void setExtraLarge(String extraLarge) {
    this.extraLarge = extraLarge;
    
  }

  /**
   * Image link for large size (width of ~800 pixels). (In LITE projection)
   * The value returned may be {@code null}.
   */
  public String getLarge() {
    return large;
  }

  /**
   * Image link for large size (width of ~800 pixels). (In LITE projection)
   * The value set may be {@code null}.
   */
  public void setLarge(String large) {
    this.large = large;
    
  }

  /**
   * Image link for medium size (width of ~575 pixels). (In LITE projection)
   * The value returned may be {@code null}.
   */
  public String getMedium() {
    return medium;
  }

  /**
   * Image link for medium size (width of ~575 pixels). (In LITE projection)
   * The value set may be {@code null}.
   */
  public void setMedium(String medium) {
    this.medium = medium;
    
  }

  /**
   * Image link for small size (width of ~300 pixels). (In LITE projection)
   * The value returned may be {@code null}.
   */
  public String getSmall() {
    return small;
  }

  /**
   * Image link for small size (width of ~300 pixels). (In LITE projection)
   * The value set may be {@code null}.
   */
  public void setSmall(String small) {
    this.small = small;
    
  }

  /**
   * Image link for small thumbnail size (width of ~80 pixels). (In LITE projection)
   * The value returned may be {@code null}.
   */
  @XmlElement(name="smallT_thumbnail")
  public String getSmallThumbnail() {
    return smallThumbnail;
  }

  /**
   * Image link for small thumbnail size (width of ~80 pixels). (In LITE projection)
   * The value set may be {@code null}.
   */
  public void setSmallThumbnail(String smallThumbnail) {
    this.smallThumbnail = smallThumbnail;
    
  }

  /**
   * Image link for thumbnail size (width of ~128 pixels). (In LITE projection)
   * The value returned may be {@code null}.
   */
  public String getThumbnail() {
    return thumbnail;
  }

  /**
   * Image link for thumbnail size (width of ~128 pixels). (In LITE projection)
   * The value set may be {@code null}.
   */
  public void setThumbnail(String thumbnail) {
    this.thumbnail = thumbnail;
    
  }

@Override
public String toString() {
	return "ImageLinks [extraLarge=" + extraLarge + ", large=" + large
			+ ", medium=" + medium + ", small=" + small + ", smallThumbnail="
			+ smallThumbnail + ", thumbnail=" + thumbnail + "]";
}

}