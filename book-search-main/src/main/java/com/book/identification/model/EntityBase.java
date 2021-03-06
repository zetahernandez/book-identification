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

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.search.annotations.DocumentId;

@MappedSuperclass
@XmlRootElement
public abstract class EntityBase {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@DocumentId
	private Long entityId;

	@XmlTransient
	public Long getEntityId() {
		return entityId;
	}

	public void setEntityId(Long id) {
		this.entityId = id;
	}

	@Transient
	@XmlID
	@XmlElement(name = "id")
	public String getEntityXmlId() {
		return Long.toString(entityId);
	}

	public void setEntityXmlId(final String entityXmlId) {
		entityId = Long.parseLong(entityXmlId);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((entityId == null) ? 0 : entityId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EntityBase other = (EntityBase) obj;
		if (entityId == null) {
			if (other.entityId != null)
				return false;
		} else if (!entityId.equals(other.entityId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EntityBase [entityId=" + entityId + "]";
	}

	@Transient
	@XmlTransient
	public boolean isPersisted() {
		return getEntityId() != null;
	}

}
