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

package com.book.identification.httpserver;

import java.util.Enumeration;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.atmosphere.cpr.AtmosphereServlet;
import org.atmosphere.di.ServletContextHolder;
import org.mortbay.jetty.Handler;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.handler.HandlerList;
import org.mortbay.jetty.handler.ResourceHandler;
import org.mortbay.jetty.servlet.Context;
import org.mortbay.jetty.servlet.ServletHolder;

public class JettyHttpServer {

	Server server = new Server(8080);

	public JettyHttpServer() throws ServletException {
		Context root = new Context(server, "/", Context.SESSIONS);
		AtmosphereServlet atmosphereServlet = new AtmosphereServlet();
		atmosphereServlet.init(new Config(root));
		
		//jersey servlet 
//		ResourceConfig rc = new PackagesResourceConfig("com.book.identification.rest");
//		rc.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,Boolean.TRUE);
//		ServletContainer servletContainer = new ServletContainer(rc);
		ServletHolder restHolder = new ServletHolder(atmosphereServlet);
		root.addServlet(restHolder, "/rest/*");
		
		//
		ResourceHandler resourceHandler = new ResourceHandler();
		resourceHandler.setResourceBase("src/main/webapp/");
		resourceHandler.setWelcomeFiles(new String[] {"index.html"});
		resourceHandler.setServer(server);
		
		HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[] { resourceHandler,root });
        server.setHandler(handlers);
	}

	 private static class Config implements ServletConfig
	 {
		 private Properties properties = new Properties();
		private Context context;
		 
		 
		public Config(Context context) {
			super();
			this.context = context; 
			this.properties.setProperty("com.sun.jersey.config.property.packages", "com.book.identification.rest");
		}

		@Override
		public String getServletName() {
			
			return "AtmosphereServlet";
		}

		@Override
		public ServletContext getServletContext() {
			return context.getServletContext();
		}

		@Override
		public String getInitParameter(String name) {
			return properties.getProperty(name);
		}

		@Override
		public Enumeration getInitParameterNames() {
			return properties.keys();
		}
	 }
	
	public void start() {
		try {
			server.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void stop() {
		try {
			server.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
