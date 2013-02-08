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
 * Author of this review.
 */
@Entity
public final class Author extends EntityBase {

	/**
	 * Name of this person. The value may be {@code null}.
	 */

	private String displayName;

	/**
	 * Name of this person. The value returned may be {@code null}.
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * Name of this person. The value set may be {@code null}.
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;

	}

	@Override
	public String toString() {
		return "Author [displayName=" + displayName + "]";
	}

}