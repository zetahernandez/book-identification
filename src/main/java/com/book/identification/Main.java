package com.book.identification;

import java.awt.Desktop;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.book.identification.httpserver.JettyHttpServer;


public class Main {

	private static Logger logger = LogManager.getLogger(Main.class);
	/**
	 * @param args	 */
	public static void main(String[] args) {
		JettyHttpServer httpServer = new JettyHttpServer();
		httpServer.start();
		HibernateUtil.getSessionFactory();
		try {
			InetAddress localHost = InetAddress.getLocalHost();
			URI uri = new java.net.URI( "http://"+localHost.getHostName()+":8080" );
			Desktop.getDesktop().browse( uri );
		} catch (IOException e) {
			logger.error(e);
		} catch (URISyntaxException e) {
			logger.error(e);
		}catch (Exception e){
			logger.error(e);
		}
		
	}
	
}
