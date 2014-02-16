package com.books.it_books;

public class PageInfo {
	
	private int numberPage;
	private String referer;
	private String url;
	private boolean fileapi;
	private String filename;
	private long length;
	private String path;
	private long downloaded;
	
	public int getNumberPage() {
		return numberPage;
	}
	public void setNumberPage(int numberPage) {
		this.numberPage = numberPage;
	}
	public String getReferer() {
		return referer;
	}
	public void setReferer(String referer) {
		this.referer = referer;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public boolean isFileapi() {
		return fileapi;
	}
	public void setFileapi(boolean fileapi) {
		this.fileapi = fileapi;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public long getLength() {
		return length;
	}
	public void setLength(long length) {
		this.length = length;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public long getDownloaded() {
		return downloaded;
	}
	public void setDownloaded(long downloaded) {
		this.downloaded = downloaded;
	}
	
	
}
