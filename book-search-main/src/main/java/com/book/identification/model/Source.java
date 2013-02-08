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


/**
   * Information regarding the source of this review, when the review is not from a Google Books user.
   */
@Entity
  public final class Source extends EntityBase{

    /**
     * Name of the source.
     * The value may be {@code null}.
     */
  
    private String description;

    /**
     * Extra text about the source of the review.
     * The value may be {@code null}.
     */
  
    private String extraDescription;

    /**
     * URL of the source of the review.
     * The value may be {@code null}.
     */
  
    private String url;

    /**
     * Name of the source.
     * The value returned may be {@code null}.
     */
    public String getDescription() {
      return description;
    }

    /**
     * Name of the source.
     * The value set may be {@code null}.
     */
    public void setDescription(String description) {
      this.description = description;
      
    }

    /**
     * Extra text about the source of the review.
     * The value returned may be {@code null}.
     */
    public String getExtraDescription() {
      return extraDescription;
    }

    /**
     * Extra text about the source of the review.
     * The value set may be {@code null}.
     */
    public void setExtraDescription(String extraDescription) {
      this.extraDescription = extraDescription;
      
    }

    /**
     * URL of the source of the review.
     * The value returned may be {@code null}.
     */
    public String getUrl() {
      return url;
    }

    /**
     * URL of the source of the review.
     * The value set may be {@code null}.
     */
    public void setUrl(String url) {
      this.url = url;
      
    }

	@Override
	public String toString() {
		return "Source [description=" + description + ", extraDescription="
				+ extraDescription + ", url=" + url + "]";
	}

  }