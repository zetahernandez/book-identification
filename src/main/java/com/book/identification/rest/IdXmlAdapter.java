package com.book.identification.rest;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.book.identification.model.EntityBase;

public class IdXmlAdapter extends XmlAdapter<Long, EntityBase> {

	@Override
	public EntityBase unmarshal(Long v) throws Exception {
		return null;
	}

	@Override
	public Long marshal(EntityBase v) throws Exception {
		return v.getEntityId();
	}

}
