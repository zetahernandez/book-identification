package com.books.it_books;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.URI;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.lang3.StringUtils;

public class DownloaderFile extends Thread {
	
    
    String x ="";
    HttpClient httpClient = null;
	public DownloaderFile(String x,  HttpClient httpClient ) {
		super();
		this.x = x;
		this.httpClient = httpClient; 
	}

	@Override
	public void run() {
//			URL dl = null;
		File fl = null;
			 FileOutputStream fos  = null;
			 ReadableByteChannel rbc = null;
	        try {
//	            dl = new URL("http://it-ebooks.info" + x );
	            
//	            URLConnection openConnection = dl.openConnection();
	            GetMethod getMethod = new GetMethod();
	            getMethod.setURI(new URI("http://it-ebooks.info" + x, false));
	            int status = httpClient.executeMethod(getMethod);
	            if(status == HttpStatus.SC_OK){
	            	rbc = Channels.newChannel(getMethod.getResponseBodyAsStream());
	            	getMethod.getResponseHeader("Content-Disposition");
		            String headerField = getMethod.getResponseHeader("Content-Disposition").getValue();//openConnection.getHeaderField("Content-Disposition");
//		            long contentlength = Long.valueOf(getMethod.getResponseHeader("Content-Length").getValue()).longValue();//openConnection.getHeaderField("Content-Disposition");
		            String filename = StringUtils.substring(headerField, StringUtils.indexOf(headerField, "filename=") + 9);
		            Path path = Paths.get(System.getProperty("user.home"), "/Desktop/it-books/",filename);
		            fl = path.toFile();
		            if(!fl.getParentFile().exists()){
		            	fl.getParentFile().mkdirs();
		            }
		            
//		            InputStream is = dl.openStream();
		            fos = new FileOutputStream(fl);
		            
//		            long expectedSize = openConnection.getContentLength();
//		            System.out.println( "Expected size: " + expectedSize );
		            ByteBuffer allocate = ByteBuffer.allocate(4096);
//		              long transferFrom = fos.getChannel().transferFrom( rbc, 0, Long.MAX_VALUE );
		              int count = 0;
		              int total = 0;
		              while (count != -1)
		              {
		            	  count = rbc.read(allocate);
		            	  fos.write(allocate.array(),0, count);
		            	  total += count;
		                  System.out.println( total + " bytes received" );
		                  allocate.clear();
		              }
	            }
	            
//	            CountingOutputStream count = new CountingOutputStream(os);
//	            
//	            IOUtils.copy(is, os);//begin transfer
//
//	            os.close();//close streams
//	            is.close();//^
//	            count.close();<
	        } catch (Exception e) {
	            System.out.println(e);
	        }finally{
	        	try {
					fos.close();
					rbc.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
	        }
	}

}
