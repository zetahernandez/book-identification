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