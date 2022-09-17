package basic;

import java.util.ArrayList;
import java.util.HashMap;

/* HashMap is non synchronized -> ConcurrentHashMap is synchronized
 * HashMap allow a null key and values -> ConcurrentHashMap doesn't
 * HashTable is synchronized - hashMap is not
 * HashTable doesnot allow nulls - hashMap does
 * 
 * HashSet and LinkedHashSet allows a null value, tree set doesnt allow any null value
 * 
 * HashMap doesnt maintains any insertion order -> LinkedHashMap maintains insertion order -> Tree Map keys are sorted
 */

public class Basics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap m = new HashMap();
        Demo d = new Demo();
         
        // puts an entry into HashMap
        m.put(d," Hi ");
         
        System.out.println(m);
        d = null;
        System.out.println(m);
        
        Demo d1 = new Demo();
        ArrayList<Demo> list1 = new ArrayList<>();
        list1.add(d1);
        System.out.println(list1);
        d1 = null;
        System.out.println(list1);
	}

}

class Demo
{
    public String toString()
    {
        return "demo";
    }
     
    // finalize method
    public void finalize()
    {
        System.out.println("Finalize method is called");
    }
}
