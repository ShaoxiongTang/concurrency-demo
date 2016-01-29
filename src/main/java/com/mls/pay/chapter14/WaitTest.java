package com.mls.pay.chapter14;

import java.util.ArrayList;


/** 
 * @author shaoxiongtang
 * @date 2016年1月27日 
 */
public class WaitTest {
	public static volatile boolean isFull = true;
	public static volatile boolean isEmpty = false;
	// public static AtomicIntegerArray array = new AtomicIntegerArray(20);
	public static ArrayList<Integer> array = new ArrayList<Integer>();
	static {
		 array.add(1);
	}
	
	public synchronized void put(Integer val) {
		System.out.println("in put method");
		while (isFull) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
			System.out.println("after wait");
		}
		array.add(new Integer(val));
		isEmpty = false;
		notifyAll();
		System.out.println("end put method");
//		try {
//			Thread.sleep(10000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	public synchronized void get() {
		System.out.println("in get method");
		while (isEmpty) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		System.out.println("after wait method");
		array.get(0);
		isFull = false;
		notifyAll();
		System.out.println("after  notifyAll method");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		final WaitTest test = new WaitTest();
		new Thread(new Runnable() {
			public void run() {
				test.put(1);
			}
		}).start();
		Thread.sleep(1000);
		new Thread(new Runnable() {
			public void run() {
				test.get();
			}
		}).start();
	}
}
