package com.book.identification.rest;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {
	private String uuid;
	
	
	public Message() {
		super();
	}

	public Message(String string) {
		setUuid(string);
	}

	@XmlElement(name="uuid")
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

}
