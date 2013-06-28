package com.book.identification.rest;

import java.nio.file.Path;

import com.book.identification.model.Volume;
import com.book.identification.work.exceptions.IdentificationException;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class IdentificationResult {

	JsonObject resultJson = new JsonObject();
	JsonParser parser = new JsonParser();
	
	public void addResultVolume(Path path, Volume volume) {
		
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("error", false);
		jsonObject.add("result", parser.parse(new Gson().toJson(volume)));

		resultJson.add(path.getFileName().toString(), jsonObject);
		
	}

	public void addErrorTo(Path path, IdentificationException e) {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("error", true);
		jsonObject.add("result", parser.parse(new Gson().toJson(e.getIdentificationError().toString())));

		resultJson.add(path.getFileName().toString(), jsonObject);	
	}
	
	
	public String getResult() {
		return resultJson.toString();
	}

}
