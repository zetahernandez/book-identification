/*
 * -----------------------------------------------------------------
 * Copyright (c) 2013 Fluid, Inc. All Right Reserved.
 * This software is the proprietary information of Fluid, Inc.
 * Use is subject to strict licensing terms.
 * -----------------------------------------------------------------
 */
package com.books.it_books;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author fernando.hernandez
 *
 */
public class MyMonitor extends Thread
{
    private ThreadPoolExecutor executor;

    private int seconds;

    private boolean run=true;

    public MyMonitor(ThreadPoolExecutor executor, int delay)
    {
        this.executor = executor;
        this.seconds=delay;
    }

    public void shutdown(){
        this.run=false;
    }

    @Override
    public void run()
    {
        while(run){
                System.out.println(
                    String.format("[monitor] [%d/%d] Active: %d, Completed: %d, Task: %d, isShutdown: %s, isTerminated: %s",
                        this.executor.getPoolSize(),
                        this.executor.getCorePoolSize(),
                        this.executor.getActiveCount(),
                        this.executor.getCompletedTaskCount(),
                        this.executor.getTaskCount(),
                        this.executor.isShutdown(),
                        this.executor.isTerminated()));
                try {
                    Thread.sleep(seconds*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }

    }
}