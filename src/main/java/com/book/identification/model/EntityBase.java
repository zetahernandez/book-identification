package com.book.identification.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;
import org.hibernate.search.annotations.DocumentId;

@MappedSuperclass
public abstract class EntityBase {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@DocumentId
	@JsonProperty("id")
	private Long entityId;
	
	@XmlElement(name="id")
	public Long getEntityId() {
		return entityId;
	}

	public void setEntityId(Long id) {
		this.entityId = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((entityId == null) ? 0 : entityId.hashCode());
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
	@JsonIgnore
	@XmlTransient
	public boolean isPersisted(){
		return getEntityId() != null;
	}
	
}
