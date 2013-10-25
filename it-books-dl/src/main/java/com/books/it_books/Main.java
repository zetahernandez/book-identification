package com.books.it_books;

import java.io.IOException;
import java.io.StringReader;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		final BlockingQueue<String[]> urls = new LinkedBlockingQueue<String[]>();
		ExtractBookFileUrl bookFileUrl = new ExtractBookFileUrl(urls, Integer
				.valueOf(args[0]).intValue(), Integer.valueOf(args[1])
				.intValue());
		new Thread(bookFileUrl).start();

		// Get the ThreadFactory implementation to use

//		ThreadFactory threadFactory = Executors.defaultThreadFactory();

		// creating the ThreadPoolExecutor

//		final ThreadPoolExecutor executorPool = new ThreadPoolExecutor(10,
//				Integer.MAX_VALUE, 10, TimeUnit.SECONDS,
//				new ArrayBlockingQueue<Runnable>(10), threadFactory,
//				new RejectedExecutionHandler() {
//
//					public void rejectedExecution(Runnable r,
//							ThreadPoolExecutor executor) {
//						System.out.println(r.toString() + " is rejected");
//
//					}
//				});
//		MyMonitor myMonitor = new MyMonitor(executorPool, 3);
//		myMonitor.start();
		final ExecutorService threadPool = Executors.newFixedThreadPool(10);
		Runnable runnable = new Runnable() {
			
			public void run() {
				HttpClient httpClient = new HttpClient(
						new MultiThreadedHttpConnectionManager());
				try {
					String[] url = {"",""};
					while (url!=null) {
						url = urls.take();
						if(url != null){
							
					threadPool.submit(new DownloaderFile(url,
									httpClient));
						}
					}

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		};
		Thread thread = new Thread(runnable);
		thread.start();

		//
		// for (int i = 2028; i < 2178; i += MAX_REQUEST) {
		// for (int j = i; j < i + MAX_REQUEST; j++) {
		//
		// }
		//
		// ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
		// for (@SuppressWarnings("rawtypes")
		// Iterator iterator = urls.iterator(); iterator.hasNext();) {
		// String url = (String) iterator.next();
		// fixedThreadPool.submit(new DownloaderFile(url));
		// }
		// try {
		// fixedThreadPool.shutdown();
		// fixedThreadPool.awaitTermination(40, TimeUnit.MINUTES);
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }
		// }

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
