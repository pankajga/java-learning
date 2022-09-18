package basic;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* Both interface can be used to implement thread
 * - In runnable you must implement the run(), but in callable you must implement the call()
 * - run() void, call() returns object
 * - In Runnable run(), if you checked exception arises then you must need to handle with try catch block.
 * - In Callable call(), you can throw checked exception
 * 
 * Future
 * When the call() method completes, answer must be stored in an object known to the main thread, so that the main thread can know about the result that the thread returned. How will the program store and obtain this result later? For this, a Future object can be used. Think of a Future as an object that holds the result – it may not hold it right now, but it will do so in the future (once the Callable returns). Thus, a Future is basically one way the main thread can keep track of the progress and result from other threads. To implement this interface, 5 methods have to be overridden, but as the example below uses a concrete implementation from the library, only the important methods are listed here.

 * Observe that Callable and Future do two different things – Callable is similar to Runnable, in that it encapsulates a task that is meant to run on another thread, whereas a Future is used to store a result obtained from a different thread. In fact, the Future can be made to work with Runnable as well, which is something that will become clear when Executors come into the picture.

 * public boolean cancel(boolean mayInterrupt): Used to stop the task. It stops the task if it has not started. If it has started, it interrupts the task only if mayInterrupt is true.
 * public Object get() throws InterruptedException, ExecutionException: Used to get the result of the task. If the task is complete, it returns the result immediately, otherwise it waits till the task is complete and then returns the result.
 * public boolean isDone(): Returns true if the task is complete and false otherwise
 * To create the thread, a Runnable is required. To obtain the result, a Future is required.
 */

public class RunnableCallable {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		
		Runnable runnable = () -> {
			System.out.println("Hello from run");
		};
		
		ExecutorService es = Executors.newFixedThreadPool(2);  // Executor Service is an interface, Executors is an implementation class of Executor Service
		Thread thread = new Thread(runnable);
		es.submit(runnable);
		
		//*********************************************************************************************************************
		
		Callable<String> callable = () -> {
			return "Hello from Callable !!!";
		};
		
		ExecutorService es1 = Executors.newFixedThreadPool(2);
		//Thread thread1 = new Thread(callable); //The constructor Thread(Callable<String>) is undefined
		Future<String> future = es1.submit(callable);
		System.out.println(future.get());
	}

}
