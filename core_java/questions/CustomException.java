package questions;

public class CustomException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			throw new MyException("Exception thrown");
		} catch (MyException e) {
			// TODO: handle exception
			System.out.println("Exception caught");
			System.out.println(e.getMessage());
		}

	}

}

class MyException extends Exception{
	String a;
	
	public MyException(String b) {
		// TODO Auto-generated constructor stub
		super(b);
		a=b;
	}
	
}