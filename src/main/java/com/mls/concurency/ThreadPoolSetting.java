package com.mls.concurency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;


/** 
 * @author shaoxiongtang
 * @date 2016年1月25日 
 */
public class ThreadPoolSetting {
	ExecutorService service = Executors.newCachedThreadPool(new MyThreadFactory());
	
	static class MyThreadFactory implements ThreadFactory{
		public Thread newThread(Runnable r) {
			return null;
		}
		
		static class MyThread extends Thread{
			private static final String DEFAULT_NAME = "mythread";
			private static final AtomicInteger alive = new AtomicInteger(0);
			
			MyThread(){
				super(DEFAULT_NAME);
				setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
					public void uncaughtException(Thread t, Throwable e) {
						
					}
				});
			}
			
			@Override
			public void run() {
				try {
					alive.incrementAndGet();
				} catch (Exception e) {
					// TODO: handle exception
				} finally {
					alive.decrementAndGet();
				}
			}
		}
	}
	public void setConfig(){
	}
}
