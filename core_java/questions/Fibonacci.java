package questions;

public class Fibonacci {
	
	public int findFibonacci(int n) {
		if(n ==1 || n== 2) {
			return 1;
		}
		int result = findFibonacci(n-1) + findFibonacci(n-2);
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fibonacci f = new Fibonacci();
		System.out.println(f.findFibonacci(12));
	}

}
