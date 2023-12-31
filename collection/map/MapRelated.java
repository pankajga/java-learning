package map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapRelated {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Key Set always the set view of keys
		// Entry Set always returns the set view of the map
		
		Map<Integer, String> map = new HashMap<>();
		// adding the key-value pairs to map
        map.put(1, "Geeks");
        map.put(2, "For");
        map.put(3, "Geeks");
        
        System.out.println("**********************Key Set Iterator********************************");
        
        Iterator<Integer> itr = map.keySet().iterator();
        while(itr.hasNext()) {
        	System.out.println(itr.next());
        }
        
        System.out.println("**********************Entry Set Iterator********************************");
        
        Iterator<Map.Entry<Integer, String>> itr1 = map.entrySet().iterator();
        while(itr1.hasNext()) {
        	System.out.println(itr1.next());
        }
        
        System.out.println("**********************Entry Set Key Value********************************");
        
        //Map.entry -> Instances of the Map.Entry interface may be obtained by iteratingthe entry-set view of a map. These instances maintain a connection to theoriginal, backing map.
        for(Map.Entry<Integer, String> entry : map.entrySet()) {
        	System.out.println(entry.getKey()+" - "+entry.getValue());
        }
        
        
	}

}

//**********************************************************************************************************************

// Java has the Map interface and HashMap is a hashtable-based implementation of this interface.
// HashTable is synchronized - hashMap is not
// HashTable doesnot allow nulls - hashMap does
// basic implementation of HashMaps in Java using an array of linked lists.
// In order to avoid collisions, we�re implementing HashMap using linked lists. 
// Why exactly are linked lists? 
/* If we wanted to resolve the problem of collisions, there was a choice to use just arrays only. 
We could move to the next index once there is a collision on some. 

But the problem with arrays is that their size needs to be defined. And since in the worst case there can be many collisions,
using an array is not so efficient. 

So we basically need a data structure whose size doesn�t need to be defined. Thus, an array of linked lists is 
the most appropriate. And the linked lists are referred to as buckets here, which means we have an array of buckets.

Hash code in java is an integer associated with each object which helps in the hashing method by finding the index of the array
where the object should be placed. This integer is calculated by calling a hashCode() function which is inbuilt in the object class. 

Implementation
Defining class
First, we�ll define and initiate a class representing a node of a linked list which will have two attributes, namely, key and value.

Initializing the buckets
The steps are as follows:

Declare and initialize a size variable to 0.
Declare an array of linked lists 
Call an initbuckets() function which initializes each bucket with an empty linked list

Insertion
Before we proceed, let�s have a recap of what�s hash code is.

Hash code in java is an integer associated with each object which helps in the hashing method by finding the index of the array where the object should be placed. This integer is calculated by calling a hashCode() function which is inbuilt in the object class. 

The steps are as follows : 

First, we create a bucket to store all the key values with the initial capacity set to 6.
Then in the insert function, we get the hash code of the key we want to insert. hashCode() function is used for that.
 
The hash code is usually an integer. As you would already know, two different objects can have the same hash code, as 
there might be an infinite number of keys but a finite number of integers. 

Using hash code, we find the module of (hash Code % array_length), in the hashfn() function, and that would give the index of the 
array in which this key will be placed. Again, two different hash codes can map to the same index. 

Then, we got to the linked list present at this index. 

If in that linked list there is no such key present (which is basically being checked by the getIndexWithinBucket() function), 
we make a new node with the key-value pair, place it at the index and increase the size by 1.

Otherwise, if there is any such key present, we update the value of �value� for that key. 
Implementation of Insertion
The function put() is used for inserting. Now, let�s see the implementation of the above approach.
*/




