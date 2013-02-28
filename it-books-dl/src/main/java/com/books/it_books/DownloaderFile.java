package com.books.it_books;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.CountingOutputStream;
import org.apache.commons.lang3.StringUtils;

public class DownloaderFile extends Thread {
	
    
    String x ="";
    
	public DownloaderFile(String x) {
		super();
		this.x = x;
	}

	@Override
	public void run() {
			URL dl = null;
			File fl = null;
	        try {
	            dl = new URL("http://it-ebooks.info" + x );
	            
	            URLConnection openConnection = dl.openConnection();
	            String headerField = openConnection.getHeaderField("Content-Disposition");
	            String filename = StringUtils.substring(headerField, StringUtils.indexOf(headerField, "filename=") + 9);
	            fl = new File(System.getProperty("user.home").replace("\\", "/") + "/Desktop/it-books/"+filename);
	            InputStream is = dl.openStream();
	            OutputStream os = new FileOutputStream(fl);
	            CountingOutputStream count = new CountingOutputStream(os);
	            
	            IOUtils.copy(is, os);//begin transfer

	            os.close();//close streams
	            is.close();//^
	            count.close();
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	}

}
