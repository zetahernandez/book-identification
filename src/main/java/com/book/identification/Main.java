package com.book.identification;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.book.identification.httpserver.JettyHttpServer;
import com.book.identification.task.CreateTreeOfCategories;


public class Main {

	private static Logger logger = LogManager.getLogger(Main.class);
	/**
	 * @param args	 */
	public static void main(String[] args) {
		JettyHttpServer httpServer = new JettyHttpServer();
		httpServer.start();
//		
		HibernateUtil.getSessionFactory();
////		
		BookIdentificationWork bookIdentificationWork = new BookIdentificationWork("BookIdentificationWork",args);  
		bookIdentificationWork.start();
		try {
			bookIdentificationWork.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		
		new CreateTreeOfCategories().execute();
		
		
	}
	
}
