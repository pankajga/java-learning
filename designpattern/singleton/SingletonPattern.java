package singleton;
/*
The singleton pattern is one of the simplest design patterns. Sometimes we need to have only one instance of our class 
for example a single DB connection shared by multiple objects as creating a separate DB connection for every object may be costly. 
Similarly, there can be a single configuration manager or error manager in an application that handles all problems instead of creating 
multiple managers.
Definition: 
The singleton pattern is a design pattern that restricts the instantiation of a class to one object. 
*/

public class SingletonPattern {

}

//Pattern-1 Classic Implementation 

class Singleton {
	private static Singleton obj;
	private Singleton() {}
	public static Singleton getInstance() {
		if(obj == null) {
			obj = new Singleton();
		}
		return obj;
	}
}
/*
- Here we have declared getInstance() static so that we can call it without instantiating the class. 
- The first time getInstance() is called it creates a new singleton object and after that it just returns the same object. 
- Note that Singleton obj is not created until we need it and call getInstance() method. 
- This is called lazy instantiation.

The main problem with above method is that it is not thread safe. Consider the following execution sequence. Refer the attached png
*/

//*********************************************************************************************************************************************

//Pattern-2 make getInstance() synchronized 

class Singleton2 {
	private static Singleton2 obj2;
	private Singleton2() {}
	public static synchronized Singleton2 getInstance2() {
		if(obj2 == null) {
			new Singleton2();
		}
		return obj2;
	}
}
/*
Here using synchronized makes sure that only one thread at a time can execute getInstance(). 
The main disadvantage of this is method is that using synchronized every time while creating the singleton object is expensive and may 
decrease the performance of your program. However if performance of getInstance() is not critical for your application this method provides 
a clean and simple solution.
*/

//***********************************************************************************************************************************************

//Pattern -3 Eager Instantiation 

class Singleton3 {
	private static Singleton3 obj = new Singleton3();
	private Singleton3() {}
	public static Singleton3 getInstance3() {
		return obj;
	}
}
/*
Here we have created instance of singleton in static initializer. JVM executes static initializer when the class is loaded and hence this 
is guaranteed to be thread safe. Use this method only when your singleton class is light and is used throughout the execution of your program.
*/

//*********************************************************************************************************************************************

//Pattern -4 (Best): Use “Double Checked Locking” 

class Singleton4 {
	private static volatile Singleton4 obj;
	private Singleton4() {}
	public static Singleton4 getInstance() {
		if(obj == null) {
			synchronized (Singleton4.class) {
				if(obj == null) {
					obj = new Singleton4();
				}
			}
		}
		return obj;
	}
}
/*
If you notice carefully once an object is created synchronization is no longer useful because now obj will not be null and any sequence 
of operations will lead to consistent results. 
So we will only acquire lock on the getInstance() once, when the obj is null. This way we only synchronize the first way through, just what we want.

We have declared the obj volatile which ensures that multiple threads offer the obj variable correctly when it is being initialized to Singleton 
instance. This method drastically reduces the overhead of calling the synchronized method every time.

public void geekName(String geek, List<String> list)
    {
        // Only one thread is permitted
        // to change geek's name at a time.
        synchronized(this)
        {
            name = geek;
            count++;  // how many threads change geek's name.
        }
  
        // All other threads are permitted
        // to add geek name into list.
        list.add(geek);
    }
*/