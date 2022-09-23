package basic;

public class BasicCreation {
	
	class FirstTypeThread extends Thread{
		public void run() {
			System.out.println("inside thread run");
		}
	}
	
	class SecondTypeThread implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("inside runnable run");
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BasicCreation bc = new BasicCreation();
		BasicCreation.FirstTypeThread t1 = bc.new FirstTypeThread();
		t1.start();
		BasicCreation.SecondTypeThread t2 = bc.new SecondTypeThread();
		Thread thread = new Thread(t2);
		thread.start();
	}

}

/* **************************************************************************************************************************************
 * Synchronized ----
 * - Synchronized is the modifier applicable only for methods and blocks but not for the variables and for classes.
 * - If a method or block is declared as synchronized, then only one thread at a time is allowed to execute that method or block on the 
 * 	 given object so that the data inconsistency problem will be resolved.
 * - Every object in java has a unique lock. The lock concept will come into picture when we are using a synchronized keyword.
 * 
 * Atomic Operation - An atomic operation is an operation which either completes entirely, or doesnot complete at all. Atomic operations cannot
 * 			partially complete. Atomic operations can help you avoid race conditions in your code.
 * 
 * Atomic vs Volatile explained well -- https://www.youtube.com/watch?v=WH5UvQJizH0
 * 
 * https://www.baeldung.com/java-volatile-vs-atomic
 */
