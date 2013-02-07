package com.book.identification.model;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * Model definition for VolumeVolumeInfoIndustryIdentifiers.
 */
@Entity
@XmlRootElement(name="industry_Identifier")
public final class IndustryIdentifiers extends EntityBase {

  /**
   * Industry specific volume identifier.
   * The value may be {@code null}.
   */

  private String identifier;

  /**
   * Identifier type. Possible values are ISBN_10, ISBN_13, ISSN and OTHER.
   * The value may be {@code null}.
   */

  private String type;

  /**
   * Industry specific volume identifier.
   * The value returned may be {@code null}.
   */
  public String getIdentifier() {
    return identifier;
  }

  /**
   * Industry specific volume identifier.
   * The value set may be {@code null}.
   */
  public void setIdentifier(String identifier) {
    this.identifier = identifier;
    
  }

  /**
   * Identifier type. Possible values are ISBN_10, ISBN_13, ISSN and OTHER.
   * The value returned may be {@code null}.
   */
  public String getType() {
    return type;
  }

  /**
   * Identifier type. Possible values are ISBN_10, ISBN_13, ISSN and OTHER.
   * The value set may be {@code null}.
   */
  public void setType(String type) {
    this.type = type;
    
  }

@Override
public String toString() {
	return "IndustryIdentifiers [identifier=" + identifier + ", type=" + type
			+ "]";
}

}