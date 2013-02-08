package com.book.identification.model.collections;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.book.identification.model.Volume;
import java.util.ArrayList;

@XmlRootElement
public class Volumes {
	
	
	private List<Volume> volumes = new ArrayList<Volume>();

	@XmlElement(name="volumes")
	public List<Volume> getVolumes() {
		return volumes;
	}

	public void setVolumes(List<Volume> volumes) {
		this.volumes = volumes;
	}
	
	
}
