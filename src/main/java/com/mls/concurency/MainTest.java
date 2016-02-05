package com.mls.concurency;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CyclicBarrier;


/** 
 * @author shaoxiongtang
 * @date 2016年1月26日 
 */
public class MainTest {
	public void testCyclicBarrier(){
		CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Runnable() {
			
			public void run() {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	private void testLeak(){
		CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<Integer>();
		list.iterator();
		Iterator<Integer> inIterator = list.iterator();
		while (inIterator.hasNext()) {
			inIterator.remove();
		}
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		Iterator<Integer> inIterator2 = list2.iterator();
		while (inIterator2.hasNext()) {
			inIterator2.remove();
		}
	}
		
}
