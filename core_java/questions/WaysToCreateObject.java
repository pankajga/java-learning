package questions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/*
	Using new keyword
	Using new instance
	Using clone() method
	Using deserialization
	Using newInstance() method of Constructor class
*/

public class WaysToCreateObject {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		
		//************************Using new keyword*********************************
		WaysToCreateObject wtco = new WaysToCreateObject();
		
		//***********************Using new instance*********************************
		/*If we know the name of the class & if it has a public default constructor we can create an object Class.forName. 
		 * We can use it to create the Object of a Class. Class.forName actually loads the Class in Java but doesn’t create any Object. To create an Object of the Class you have to use the new Instance Method of the Class.
		 */
		Class cls = Class.forName("WaysToCreateObject");
		WaysToCreateObject wtco1 = (WaysToCreateObject) cls.newInstance();
		
		//***********************Using clone() method********************************
		//Refer cloneable section
		

	}

}

//***********************Using deserialization********************************

class SerializationDemo implements Serializable {
	private String name;
	public SerializationDemo(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}
	public static void main(String[] args) {
		SerializationDemo sd = new SerializationDemo("This is a serialization demo");
		try {
			FileOutputStream fos = new FileOutputStream("file.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(sd);
			oos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
//Object of SerializationDemo class is serialized using writeObject() method and written to file.txt file.

class GFG {
	 
    // Main driver method
    public static void main(String[] args)
    {
 
        // Try block to check for exceptions
        try {
 
            GFG d;
 
            // Creating FileInputStream class object
            FileInputStream f
                = new FileInputStream("file.txt");
 
            // Creating ObjectInputStream class object
            ObjectInputStream oos
                = new ObjectInputStream(f);
            d = (GFG) oos.readObject();
        }
 
        // Catch block to handle the exceptions
        catch (Exception e) {
 
            // Display the exception on console
            // using printStacjtrace() method
            e.printStackTrace();
        }
 
        //System.out.println(d.name);
    }
}

//*********************Method 5: Using newInstance() method of the constructor class********************************

class GFG1 {
	private String name;
	GFG1() {}
	
	public static void main(String[] args) {
		try {
			Constructor<GFG1> constructor = GFG1.class.getDeclaredConstructor();
			GFG1 r = constructor.newInstance();
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
