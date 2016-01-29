package com.mls.pay;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;


/** 
 * @author shaoxiongtang
 * @date 2016年1月20日 
 */
public class TimerDemo {
	public static void main(String[] args) {
		Timer timer = new Timer();
//		timer.scheduleAtFixedRate(new TimerTask() {
//			@Override
//			public void run() {
//				System.out.println(new Date());
//				try {
//					Thread.sleep(1000);
//				} catch (Exception e) {
//					// TODO: handle exception
//				}
//			}
//		}, new Date(), 2000);
		
//		timer.scheduleAtFixedRate(new TimerTask() {
//			@Override
//			public void run() {
//				try {
//					Thread.sleep(1000);
//				} catch (Exception e) {
//					System.out.println("error");
//				}
//				System.out.println(new Date());
//			}
//		}, 0, 2000);
		
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				throw new RuntimeException();
//				try {
//					Thread.sleep(10000);
//				} catch (Exception e) {
//					System.out.println("error");
//				}
//				System.out.println(new Date());
			}
		}, 1000);
		DelayQueue<DelayedTask> dq = new DelayQueue<DelayedTask>();
		
//		timer.schedule(new TimerTask() {
//			
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				
//			}
//		}, delay);
	}
	
	public static class DelayedTask implements Delayed{

		public int compareTo(Delayed o) {
			// TODO Auto-generated method stub
			return 0;
		}

		public long getDelay(TimeUnit unit) {
			// TODO Auto-generated method stub
			return 0;
		}
	}
}
