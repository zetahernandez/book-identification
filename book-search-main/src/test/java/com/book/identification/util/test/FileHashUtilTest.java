package com.book.identification.util.test;

import java.io.File;
import java.net.URISyntaxException;

import junit.framework.Assert;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.book.identification.util.FileHashUtil;

public class FileHashUtilTest {
	
	Logger logger = LogManager.getLogger(FileHashUtilTest.class);
	
	@Test
	public void test() throws URISyntaxException {
		long start = System.currentTimeMillis();
		String fileSHA1_1 = FileHashUtil.getFileSHA1(new File(ClassLoader.getSystemResource("19.pdf").toURI()));
		String fileSHA1_2 = FileHashUtil.getFileSHA1(new File(ClassLoader.getSystemResource("bookFolder/165.pdf").toURI()));
		String fileSHA1_3 = FileHashUtil.getFileSHA1(new File(ClassLoader.getSystemResource("173.pdf").toURI()));
		String fileSHA1_4 = FileHashUtil.getFileSHA1(new File(ClassLoader.getSystemResource("32.pdf").toURI()));
		long end = System.currentTimeMillis();
		
		Assert.assertEquals(fileSHA1_1, fileSHA1_2);
		Assert.assertEquals(fileSHA1_1, fileSHA1_3);
		Assert.assertEquals(fileSHA1_1, fileSHA1_4);
		long time = (end - start) / 1000;
		logger.info("finish in " + time + " seconds");
	}

}
