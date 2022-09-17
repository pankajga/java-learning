package map;

import java.util.HashMap;
import java.util.WeakHashMap;

/* HashMap
 * HashMap class is hashing based implementation. In hash map we have a key and value pair.
 * Even though the object is specified as key n hash map, it doesnot have any reference and is not eligible
 * for garbage collection if it is associated with HashMap i.e. HashMap dominates over GC.
 * 
 * WeakHashMap
 * WeakHashMap is an implementation of the map interface. WeakHashMap is almost same as HashMap, except
 * in case of WeakHashMap, even if object specified as key doesn't contain any references- it is eligible
 * for garbage collection even though it is associated with WeakHashMap i.e. Garbage Collector dominates
 * over WeakHashMap
 */

public class WeakHashMapDef {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Demo d1 = new Demo();
		HashMap<Demo, Integer> hm1 = new HashMap<>();
		hm1.put(d1, 1);
		System.out.println(d1); // Demo
		System.out.println(hm1); // {Demo=1}
		d1 = null;
		System.gc();
		Thread.sleep(4000);
		System.out.println(d1); // null
		System.out.println(hm1); // {Demo=1}
		
		////////////////////////////Weak Hash Map///////////////////////
		
		Demo d2 = new Demo();
		WeakHashMap<Demo, Integer> hm2 = new WeakHashMap<>();
		hm2.put(d2, 2);
		System.out.println(hm2); //{Demo=2}
		d2 = null;
		System.gc(); // Finalize called
		Thread.sleep(4000);
		System.out.println(hm2); // {}

	}

}

class Demo {
	public String toString() {
		return "Demo";
	}
	
	public void finalize() {
		System.out.println("Finalize called");
	}
}
