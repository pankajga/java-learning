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
