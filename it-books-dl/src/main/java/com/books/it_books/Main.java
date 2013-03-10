package com.books.it_books;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class Main {

	private static final int MAX_REQUEST = 10;
	public static final String IT_BOOKS_URL = "http://it-ebooks.info/book/";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HttpClient httpClient = new DefaultHttpClient();

		for (int i = 1740; i < 1767; i += MAX_REQUEST) {
			List<String> urls = new ArrayList<String>();

			for (int j = i; j < i + MAX_REQUEST; j++) {
				HttpGet httpGet = new HttpGet(IT_BOOKS_URL
						+ String.valueOf(j + 1));
				try {
					HttpResponse httpResponse = httpClient.execute(httpGet);
					HttpEntity httpEntity = httpResponse.getEntity();
					String xml = EntityUtils.toString(httpEntity);
					int start = StringUtils.lastIndexOf(xml,
							"<a id=\"dl\" href=\"") + 17;
					int end = StringUtils.indexOf(xml, "\"", start);

					urls.add(StringUtils.substring(xml, start, end));
				} catch (ClientProtocolException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
			for (@SuppressWarnings("rawtypes")
			Iterator iterator = urls.iterator(); iterator.hasNext();) {
				String url = (String) iterator.next();
				fixedThreadPool.submit(new DownloaderFile(url));
			}
			try {
				fixedThreadPool.shutdown();
				fixedThreadPool.awaitTermination(40, TimeUnit.MINUTES);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * Getting XML DOM element
	 * 
	 * @param XML
	 *            string
	 * */
	public static Document getDomElement(String xml) {
		Document doc = null;
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setValidating(false);

		try {

			DocumentBuilder db = dbf.newDocumentBuilder();

			InputSource is = new InputSource();
			is.setCharacterStream(new StringReader(xml));
			doc = db.parse(is);

		} catch (ParserConfigurationException e) {
			return null;
		} catch (SAXException e) {
			return null;
		} catch (IOException e) {
			return null;
		}

		return doc;
	}

	public static final String getElementValue(Node elem, boolean html) {
		Node child;
		if (elem != null) {
			if (elem.hasChildNodes()) {
				for (child = elem.getFirstChild(); child != null; child = child
						.getNextSibling()) {
					if (child.getNodeType() == Node.TEXT_NODE) {
						// return child.getNodeValue();
						return child.getNodeValue();
					}
				}
			}
		}
		return "";
	}

	/**
	 * Getting node value
	 * 
	 * @param Element
	 *            node
	 * @param key
	 *            string
	 * */

	public static String getValue(Element item, String str) {
		NodeList n = item.getElementsByTagName(str);

		return getElementValue(n.item(0), false);
	}

}
