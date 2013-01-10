package com.book.identification.httpserver;

import org.mortbay.jetty.Handler;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.handler.HandlerList;
import org.mortbay.jetty.handler.ResourceHandler;
import org.mortbay.jetty.servlet.Context;
import org.mortbay.jetty.servlet.ServletHolder;

import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.api.json.JSONConfiguration;
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
