package com.book.identification;

public class ClientCredentials {
	 /** Value of the "API key" shown under "Simple API Access". */
	 public static final String API_KEY = "AIzaSyD0HnKP5Z3DbPEIJOYnJ99SvFMTZcB0rw8";

	  static void errorIfNotSpecified() {
	    if (API_KEY.startsWith("Enter ")) {
	      System.err.println(API_KEY);
	      System.exit(1);
	    }
	  }
}
