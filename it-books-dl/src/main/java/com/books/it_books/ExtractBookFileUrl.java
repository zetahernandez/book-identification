/*
 * -----------------------------------------------------------------
 * Copyright (c) 2013 Fluid, Inc. All Right Reserved.
 * This software is the proprietary information of Fluid, Inc.
 * Use is subject to strict licensing terms.
 * -----------------------------------------------------------------
 */
package com.books.it_books;

import java.io.IOException;
import java.util.concurrent.BlockingQueue;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.URI;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @author fernando.hernandez
 *
 */
public class ExtractBookFileUrl implements Runnable {
	BlockingQueue<String> urls;
	
	public static final String IT_BOOKS_URL = "http://it-ebooks.info/book/";
	public static final String PATTERN = "<a id=\"dl\" href=\"";
	
	HttpClient httpClient = new HttpClient(new MultiThreadedHttpConnectionManager());
	private int init;
	private int stop;
	public ExtractBookFileUrl(BlockingQueue<String> urls,int init, int stop) {
		this.urls = urls;
		this.init = init;
		this.stop = stop;

	}


	public void run() {
		for (int i = init; i < stop; i++) {
			GetMethod httpGet = new GetMethod();
//			HttpGet httpGet = new HttpGet(IT_BOOKS_URL + String.valueOf( i));
			try {
				httpGet.setURI(new URI(IT_BOOKS_URL + String.valueOf( i),false));
				int statusCode = httpClient.executeMethod(httpGet);
				if(statusCode == HttpStatus.SC_OK){
					String xml = IOUtils.toString(httpGet.getResponseBodyAsStream());
					int start = StringUtils.lastIndexOf(xml,
							PATTERN) + PATTERN.length();
					int end = StringUtils.indexOf(xml, "\"", start);
		
					urls.add(StringUtils.substring(xml, start, end));
				}
//				HttpEntity httpEntity = httpResponse.getEntity();
//				String xml = EntityUtils.toString(httpEntity);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		urls.add("END");
	}

}
