package com.book.identification.rest;

import java.nio.file.Path;

import com.book.identification.model.Volume;
import com.book.identification.work.exceptions.IdentificationException;
import com.book.identification.work.exceptions.VolumeNotFoundExecption;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class IdentificationResult {

	JsonObject resultJson = new JsonObject();
	
	public void addResultVolume(Path path, Volume volume) {
		
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("error", false);
		jsonObject.addProperty("volume", new Gson().toJson(volume));

		resultJson.add(path.getFileName().toString(), jsonObject);
		
	}

	public void addErrorTo(Path path, IdentificationException e) {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("error", true);
		
		JsonObject error = new JsonObject();
		error.addProperty("errorType",  new Gson().toJson(e.getIdentificationError().toString()));
		if(e instanceof VolumeNotFoundExecption){
			String isbn = ((VolumeNotFoundExecption) e).getISBN();
			error.addProperty("isbn", isbn);
		}
		jsonObject.add("error",error);

		resultJson.add(path.getFileName().toString(), jsonObject);	
	}
	
	
	public String getResult() {
		return resultJson.toString();
	}

}
