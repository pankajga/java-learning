package questions;

public class Factorial {
	
	public int findFactorial(int number) {
		if(number == 0 || number == 1) {
			return 1;
		}
		int result = number * findFactorial(number-1);
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Factorial f = new Factorial();
		System.out.println(f.findFactorial(6));

	}

}
