package com.book.identification.model.collections;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.book.identification.model.Volume;

@XmlRootElement
public class Volumes {
	
	
	private List<Volume> volumes;

	@XmlElement(name="volumes")
	public List<Volume> getVolumes() {
		return volumes;
	}

	public void setVolumes(List<Volume> volumes) {
		this.volumes = volumes;
	}
	
	
}
