// Copyright 2013 fernando.hernandez

// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at

//   http://www.apache.org/licenses/LICENSE-2.0

// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.book.identification;

import java.awt.Desktop;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.atmosphere.cpr.AtmosphereServlet;

import com.book.identification.httpserver.JettyHttpServer;


public class Main {

	private static Logger logger = LogManager.getLogger(Main.class);
	/**
	 * @param args	 */
	public static void main(String[] args) {
		try {
			JettyHttpServer.init();
			Map<String,String> properties = new HashMap<String, String>();
			properties.put("com.sun.jersey.config.property.packages","com.book.identification.rest");
			JettyHttpServer.registerServlet(AtmosphereServlet.class, "/rest/*",properties);
			JettyHttpServer.start();
		} catch (Exception e1) {
			logger.error(e1);
			System.exit(0);
		}
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
