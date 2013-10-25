package com.books.it_books;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.URI;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

public class DownloaderFile extends Thread {
	
    
    String[] x = null;
    HttpClient httpClient = null;
	public DownloaderFile(String[] x,  HttpClient httpClient ) {
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
	            getMethod.setURI(new URI(x[0], false));
	            
	            getMethod.addRequestHeader("Cookie", "PHPSESSID=n4o4raa7g1jmjleu67c8n3o1c5; _jsuid=1675556146; unpoco_100645839=1; __atuvc=2%7C43");
				getMethod.addRequestHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
				getMethod.addRequestHeader("Accept-Encoding","gzip,deflate,sdch");
				getMethod.addRequestHeader("Connection","keep-alive");
				getMethod.addRequestHeader("Host","filepi.com");
				getMethod.addRequestHeader("Referer",x[1]);
				getMethod.addRequestHeader("User-Agent","Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/30.0.1599.69 Safari/537.36");
				getMethod.setDoAuthentication(true);
				//http://stackoverflow.com/questions/2263062/how-to-monitor-progress-jprogressbar-with-filechannels-transferfrom-method
	            int status = httpClient.executeMethod(getMethod);
	            if(status == HttpStatus.SC_OK){
	            	rbc = Channels.newChannel(getMethod.getResponseBodyAsStream());
//	            	getMethod.getResponseHeader("Content-Disposition");
	            	String filename = "";
	            	if(getMethod.getResponseHeader("Content-Disposition")!=null){
			            String headerField = getMethod.getResponseHeader("Content-Disposition").getValue();//openConnection.getHeaderField("Content-Disposition");
			            filename = StringUtils.substring(headerField, StringUtils.indexOf(headerField, "filename=") + 9);
			            filename = filename.replace("\"", "");
	            	}else{
	            		filename =RandomStringUtils.randomAlphabetic(10);
	            	}

//		            long contentlength = Long.valueOf(getMethod.getResponseHeader("Content-Length").getValue()).longValue();//openConnection.getHeaderField("Content-Disposition");
		            
		            Path path = Paths.get(System.getProperty("user.home"), "/Desktop/it-books/",filename);
		            fl = path.toFile();
		            if(!fl.getParentFile().exists()){
		            	fl.getParentFile().mkdirs();
		            }
		            
//		            InputStream is = dl.openStream();
		            fos = new FileOutputStream(fl);
		            
//		            long expectedSize = openConnection.getContentLength();
//		            System.out.println( "Expected size: " + expectedSize );
//		            ByteBuffer allocate = ByteBuffer.allocate(4096);
		            
		            long transferFrom = fos.getChannel().transferFrom( rbc, 0, Long.MAX_VALUE );
//		              int count = 0;
//		              int total = 0;
//		              while (count != -1)
//		              {
//		            	  count = rbc.read(allocate);
//		            	  fos.write(allocate.array(),0, count);
//		            	  total += count;
//		                  System.out.println( total + " bytes received" );
//		                  allocate.clear();
//		              }
	            }
	            
//	            CountingOutputStream count = new CountingOutputStream(os);
//	            
//	            IOUtils.copy(is, os);//begin transfer
//
//	            os.close();//close streams
//	            is.close();//^
//	            count.close();<
	        } catch (Throwable e) {
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
