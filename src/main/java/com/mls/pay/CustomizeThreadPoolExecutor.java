package com.mls.pay;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.jar.Attributes.Name;

/**
 * @author shaoxiongtang
 * @date 2016年1月25日
 */
public class CustomizeThreadPoolExecutor extends ThreadPoolExecutor {

	public CustomizeThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
	}

	@Override
	protected void beforeExecute(Thread t, Runnable r) {
		// TODO Auto-generated method stub
		super.beforeExecute(t, r);
	}

	@Override
	protected void afterExecute(Runnable r, Throwable t) {
		// TODO Auto-generated method stub
		super.afterExecute(r, t);
	}

	@Override
	protected void terminated() {
		// TODO Auto-generated method stub
		super.terminated();
	}

	public static void main(String[] args) {
		Set<Obj> set1 = new HashSet<Obj>();
		Obj obj = new Obj("obj1");
		set1.add(obj);
		Set<Obj> set2 = new HashSet<Obj>(set1);
		obj.setName("obj2");
		System.out.println(set2);

	}

	static class Obj {
		String name;

		public Obj(String name) {
			this.name = name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		@Override
		public String toString() {
			return name;
		}
	}
}
