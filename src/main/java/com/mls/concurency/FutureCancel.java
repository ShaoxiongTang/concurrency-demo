package com.mls.concurency;

import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;


/** 
 * @author shaoxiongtang
 * @date 2016年1月22日 
 */
public class FutureCancel {
	public interface CancellableTask<T> extends Callable<T>{
		void cancel();
		RunnableFuture<T> newtask();
	}
}
