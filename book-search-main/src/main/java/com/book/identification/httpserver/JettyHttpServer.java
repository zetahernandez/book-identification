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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class JettyHttpServer {

	// all Jetty objects required to start
	private static final Server server = new Server();
	private static final ServletContextHandler context = new ServletContextHandler(server, "/");
	private static final SelectChannelConnector connector = new SelectChannelConnector();
	private static final HandlerList mainHandler = new HandlerList();
	private static int port = 8080;
//	private static ServletHandler servletHandler = new ServletHandler();

	// local lists storing the servlets
//	private static final List<ServletHolder> holders = new ArrayList<ServletHolder>();
//	private static final List<ServletMapping> mappings = new ArrayList<ServletMapping>();

	// protocol bits
	private static boolean initAlreadyCalled = false;


	/** Initializes the server */
	public static void init() throws Exception {
		if (initAlreadyCalled) {
			throw new RuntimeException("init() already called");
		}
		// init config
		connector.setPort(port);
		Connector[] c = { connector };
		server.setConnectors(c);

		// serving static files
		// "./src/JettyServer.java" is accessible at
		// "http://localhost:8080/src/JettyServer.java"
		ResourceHandler resourceHandler = new ResourceHandler();
		resourceHandler.setResourceBase("src/main/webapp/");
		resourceHandler.setWelcomeFiles(new String[] {"index.html"});
		// recall that Jetty takes into account
		// the first handler which matches the requested URI
		mainHandler.addHandler(resourceHandler);
		mainHandler.addHandler(context);
		server.setHandler(mainHandler);

		initAlreadyCalled = true;
	}

	/** Starts the server */
	public static void start() throws Exception {
		if (!initAlreadyCalled) {
			throw new RuntimeException("init() must be called before start()");
		}
//		servletHandler.setServlets(holders.toArray(new ServletHolder[0]));
//		servletHandler.setServletMappings(mappings.toArray(new ServletMapping[0]));
		server.start();
	}

	/**
	 * Registers a servlet in the server on the given path. Example:
	 * registerServlet(foo.CommentingServlet.class, "/c/*");
	 * */
	public static void registerServlet(Class<?> servlet, String path, Map<String, String> parameters) {
		if (!initAlreadyCalled) {
			throw new RuntimeException(
					"init() must be called before registerServlet()");
		}
		ServletHolder holder = new ServletHolder();
		holder.setName(servlet.getName());
		holder.setClassName(servlet.getName());
		
		if(parameters == null){
			parameters = new HashMap<String, String>();
		}
		holder.setInitParameters(parameters);
		context.addServlet(holder, path);
		
	}
	
}
