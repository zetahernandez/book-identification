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

import org.mortbay.jetty.Handler;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.handler.HandlerList;
import org.mortbay.jetty.handler.ResourceHandler;
import org.mortbay.jetty.servlet.Context;
import org.mortbay.jetty.servlet.ServletHolder;

import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.spi.container.servlet.ServletContainer;

public class JettyHttpServer {

	Server server = new Server(8080);

	public JettyHttpServer() {
		Context root = new Context(server, "/", Context.SESSIONS);
		
		//jersey servlet 
		ResourceConfig rc = new PackagesResourceConfig("com.book.identification.rest");
//		rc.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,Boolean.TRUE);
		ServletContainer servletContainer = new ServletContainer(rc);
		ServletHolder restHolder = new ServletHolder(servletContainer);
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
