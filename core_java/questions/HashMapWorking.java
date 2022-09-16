package questions;

import java.util.LinkedList;

// Nicely Explained: https://www.codingninjas.com/codestudio/library/implementation-of-hashmap

//Java has the Map interface and HashMap is a hashtable-based implementation of this interface.
//HashTable is synchronized - hashMap is not
//HashTable doesnot allow nulls - hashMap does
//basic implementation of HashMaps in Java using an array of linked lists.
//In order to avoid collisions, we’re implementing HashMap using linked lists. 
//Why exactly are linked lists? 
/* If we wanted to resolve the problem of collisions, there was a choice to use just arrays only. 
We could move to the next index once there is a collision on some. 

But the problem with arrays is that their size needs to be defined. And since in the worst case there can be many collisions,
using an array is not so efficient. 

So we basically need a data structure whose size doesn’t need to be defined. Thus, an array of linked lists is 
the most appropriate. And the linked lists are referred to as buckets here, which means we have an array of buckets.

Hash code in java is an integer associated with each object which helps in the hashing method by finding the index of the array
where the object should be placed. This integer is calculated by calling a hashCode() function which is inbuilt in the object class. 

Implementation
Defining class
First, we’ll define and initiate a class representing a node of a linked list which will have two attributes, namely, key and value.

Initializing the buckets
The steps are as follows:

Declare and initialize a size variable to 0.
Declare an array of linked lists 
Call an initbuckets() function which initializes each bucket with an empty linked list

Insertion
Before we proceed, let’s have a recap of what’s hash code is.

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

Otherwise, if there is any such key present, we update the value of “value” for that key. 
Implementation of Insertion
The function put() is used for inserting. Now, let’s see the implementation of the above approach.

Retrieval
To retrieve a value with the help of key, get() function is used.

The steps are as follows : 

First, compute the hash code of the key-value you want to retrieve.
Find the index by taking the modulo (hash code% array_size). hashfn() does this.
Call the getIndexWithinBucket() function for that index. What it does is, checks if there is any such already present. If there is, it returns the index of the linked list at which it is present. Otherwise, it just returns -1.
When we have got the bucket index (bi) and the linked list (di), we just return the value of the node at that index. 
And if we’ve received -1 from the getIndexWithinBucket() function, we just return null because the key isn’t there in the hashmap.

Check if the HashMap contains a given key
To check if a key is present in the hashMap or not, we use the containsKey() function which returns a boolean value (true if the key is present, otherwise false). 

The steps are as follows:

First, compute the hash code of the key-value you want to retrieve.
Find the index by taking the modulo (hash code% array_size). hashfn() does this.
Call the getIndexWithinBucket() function for that index. What it does is, checks if there is any such already present. If there is, it returns the index of the linked list at which it is present. Otherwise, it just returns -1.
If the value returned by the getIndexWithinBucket() function is -1, it means that the key is not in the HashMap, so just return false. Otherwise, return true.

***** Find the index by taking the modulo (hash code% array_size). hashfn() does this.
*****
* Hash Map is an array of linkedList.
* We find the hashcode using hashcode() method present in Object class
* We find index of the array using modulo (hash code% array_size).
* If in that linked list there is no such key present (which is basically being checked by the getIndexWithinBucket() --> ((if(node.key.equals(key))
*  function), 
* we make a new node with the key-value pair, place it at the index and increase the size by 1.
	***********Otherwise, if there is any such key present, we update the value of “value” for that key. 
* 
*/
public class HashMapWorking {
	public static class HashMap<K,V> {
		private class Node {
			K key;
			V value;
			Node(K key, V value) {
		        this.key = key;
		        this.value = value;
		    }
		}
		
		private int size;
		private LinkedList<Node>[] buckets;
		
		public HashMap() {
			initbuckets(4);
		    size = 0;
		}
		
		private void initbuckets(int N) {
			buckets = new LinkedList[N];
			for (int bi = 0; bi < buckets.length; bi++) {
		        buckets[bi] = new LinkedList<>();
		    }
		}
		
		public void put(K key, V value) throws Exception {
		      int bi = hashfn(key);
		      int di = getIndexWithinBucket(key,bi);
		      if(di!=-1){
		          Node node = buckets[bi].get(di);
		          node.value = value;
		      }
		      else{
		          Node node = new Node(key,value);
		          buckets[bi].add(node);
		          size++;
		      }
		    }
		    
		    private int hashfn(K key){
		        int hc = key.hashCode();
		        return Math.abs(hc)%buckets.length;
		    }
		    
		    private int getIndexWithinBucket(K key, int bi){
		        int di = 0;
		        for(Node node : buckets[bi]){
		            if(node.key.equals(key)){
		                return di;
		            }
		            di++;
		        }
		        return -1;
		    }
	}

}
