package features;

/* Note that lambda expressions can only be used to implement functional interfaces.
 * Lambda expressions basically express instances of functional interfaces
 * lambda expressions implement the only abstract function and therefore implement functional interfaces
 * 
 * -> this expression is lambda expression - basically to create an instance of functional interface
 */

public class LambdaFunctionalInterface {

}

//Java program to demonstrate lambda expressions
//to implement a user defined functional interface.

//A sample functional interface (An interface with
//single abstract method
interface FuncInterface
{
	// An abstract function
	void abstractFun(int x);

	// A non-abstract (or default) function
	default void normalFun()
	{
	System.out.println("Hello");
	}
}

class Test
{
	public static void main(String args[])
	{
		// lambda expression to implement above
		// functional interface. This interface
		// by default implements abstractFun()
		FuncInterface fobj = (int x)->System.out.println(2*x);

		// This calls above lambda expression and prints 10.
		fobj.abstractFun(5);
	}
}


/* Default Methods and Multiple Inheritance
In case both the implemented interfaces contain default methods with same method signature, the implementing class should explicitly
 specify which default method is to be used or it should override the default method.
 */

//A simple Java program to demonstrate multiple
//inheritance through default methods.
interface TestInterface1
{
	// default method
	default void show()
	{
		System.out.println("Default TestInterface1");
	}
}

interface TestInterface2
{
	// Default method
	default void show()
	{
		System.out.println("Default TestInterface2");
	}
}

//Implementation class code
class TestClass implements TestInterface1, TestInterface2
{
	// Overriding default show method
	public void show()
	{
		// use super keyword to call the show
		// method of TestInterface1 interface
		TestInterface1.super.show();

		// use super keyword to call the show
		// method of TestInterface2 interface
		TestInterface2.super.show();
	}

	public static void main(String args[])
	{
		TestClass d = new TestClass();
		d.show();
	}
}

