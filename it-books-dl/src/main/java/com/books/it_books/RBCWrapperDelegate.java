package com.books.it_books;

import com.books.it_books.DownloaderFile.ProgressRBC;

public interface RBCWrapperDelegate {
	        // The RBCWrapperDelegate receives rbcProgressCallback() messages
	        // from the read loop.  It is passed the progress as a percentage
	        // if known, or -1.0 to indicate indeterminate progress.
	        // 
	        // This callback hangs the read loop so a smart implementation will
	        // spend the least amount of time possible here before returning.
	        // 
	        // One possible implementation is to push the progress message
	        // atomically onto a queue managed by a secondary thread then
	        // wake that thread up.  The queue manager thread then updates
	        // the user interface progress bar.  This lets the read loop
	        // continue as fast as possible.
	        public void rbcProgressCallback( ProgressRBC rbc,long total, double progress );
}
