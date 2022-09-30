package questions;

/*
 * Object cloning refers to the creation of an exact copy of an object. 
 * It creates a new instance of the class of the current object and initializes all its fields with exactly the contents of the corresponding 
 * fields of this object.
 * 
 */

public class CloningImpl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

//**************Using Assignment Operator to create a copy of the reference variable********************************************

/* In Java, there is no operator to create a copy of an object. 
 * Unlike C++, in Java, if we use the assignment operator then it will create a copy of the reference variable and not the object. 
 * This can be explained by taking an example. The following program demonstrates the same.
*/

class Test {
	int x;
	int y;
	Test() {
		x=10;
		y=20;
	}
}

class Main {
	public static void main(String[] args) {
		Test test1 = new Test();
		System.out.println("x = "+test1.x+" y = "+test1.y); //x = 10 y = 20
		Test test2 = test1;
		test2.x = 100;
		System.out.println("x = "+test1.x+" y = "+test1.y); //x = 100 y = 20
		System.out.println("x = "+test2.x+" y = "+test2.y); //x = 100 y = 20
	}
}

//**************Creating a copy using the clone() method************************************************************************

/*
The class whose object’s copy is to be made must have a public clone method in it or in one of its parent class.  

Every class that implements clone() should call super.clone() to obtain the cloned object reference.
The class must also implement java.lang.Cloneable interface whose object clone we want to create otherwise it will throw CloneNotSupportedException 
when clone method is called on that class’s object.
Syntax:
  protected Object clone() throws CloneNotSupportedException
Usage of clone() method -Shallow Copy

Please Note – In the below code example the clone() method does create a completely new object with a different hashCode value, 
which means its in a separate memory location. But due to the Test object c being inside Test2, the primitive types have achieved deep copy 
but this Test object c is still shared between t1 and t2. To overcome that we explicitly do a deep copy for object variable c, 
which is discussed later. 
*/

class Test1 {
	int x,y;
}

class Test2 implements Cloneable {
	int a;
	int b;
	Test1 c = new Test1();
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

class Main1 {
	public static void main(String[] args) throws CloneNotSupportedException {
		Test2 test2 = new Test2();
		Test2 test2Cloned = (Test2) test2.clone();
		// Creating a copy of object t1
        // and passing it to t2
		test2.a = 100;
 
        // Change in primitive type of t2 will
        // not be reflected in t1 field
		test2.c.x = 300;
 
        // Change in object type field will be
        // reflected in both t2 and t1(shallow copy)
        System.out.println(test2.a + " " + test2.b + " " + test2.c.x   // 10 20 300 40
                           + " " + test2.c.y);
        System.out.println(test2Cloned.a + " " + test2Cloned.b + " " + test2Cloned.c.x   // 10 20 300 40
                           + " " + test2Cloned.c.y);
        
        //In the above example, t1.clone returns the shallow copy of the object t1. 
        //To obtain a deep copy of the object certain modifications have to be made in the clone method after obtaining the copy.
	}
}

/*In the above example, t1.clone returns the shallow copy of the object t1. 
 * To obtain a deep copy of the object certain modifications have to be made in the clone method after obtaining the copy.
 */

/* Deep Copy vs Shallow Copy

Shallow copy is the method of copying an object and is followed by default in cloning. In this method, 
the fields of an old object X are copied to the new object Y. While copying the object type field the reference is copied to Y i.e object Y 
will point to the same location as pointed out by X. If the field value is a primitive type it copies the value of the primitive type.
Therefore, any changes made in referenced objects in object X or Y will be reflected in other objects.
Shallow copies are cheap and simple to make. In the above example, we created a shallow copy of the object.

Usage of clone() method – Deep Copy 

If we want to create a deep copy of object X and place it in a new object Y then a new copy of any referenced objects 
fields are created and these references are placed in object Y. This means any changes made in referenced object fields in object X or Y 
will be reflected only in that object and not in the other. In the below example, we create a deep copy of the object.
A deep copy copies all fields and makes copies of dynamically allocated memory pointed to by the fields. A deep copy occurs when an object is 
copied along with the objects to which it refers.
*/

//A Java program to demonstrate
//deep copy using clone()

//An object reference of this
//class is contained by Test2
class Test4 {
 int x, y;
}

//Contains a reference of Test and
//implements clone with deep copy.
class Test5 implements Cloneable {
	 int a, b;
	
	 Test4 c = new Test4();
	
	 public Object clone() throws CloneNotSupportedException
	 {
	     // Assign the shallow copy to
	     // new reference variable t
		 Test5 t = (Test5)super.clone();
	
	     // Creating a deep copy for c
	     t.c = new Test4();
	     t.c.x = c.x;
	     t.c.y = c.y;
	
	     // Create a new object for the field c
	     // and assign it to shallow copy obtained,
	     // to make it a deep copy
	     return t;
	 }
	}

class Main4 {
 public static void main(String args[])
     throws CloneNotSupportedException
 {
     Test2 t1 = new Test2();
     t1.a = 10;
     t1.b = 20;
     t1.c.x = 30;
     t1.c.y = 40;

     Test2 t3 = (Test2)t1.clone();
     t3.a = 100;

     // Change in primitive type of t2 will
     // not be reflected in t1 field
     t3.c.x = 300;

     // Change in object type field of t2 will
     // not be reflected in t1(deep copy)
     System.out.println(t1.a + " " + t1.b + " " + t1.c.x
                        + " " + t1.c.y);
     System.out.println(t3.a + " " + t3.b + " " + t3.c.x
                        + " " + t3.c.y);
 }
}