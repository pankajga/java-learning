package questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;



// Association vs Aggregation vs Composition
/*	Trick to remember the difference :

		"Has-A": Aggregation
		"Part-Of": cOmPositoin
		"Is-a": Inheritance

		or two objects, Foo and Bar the relationships can be defined

		Association - I have a relationship with an object. Foo uses Bar

		public class Foo {         
		    private Bar bar;
		};
		NB: See Fowler's definition - the key is that Bar is semantically related to Foo rather than just a dependency (like an int or string).

		Composition - I own an object and I am responsible for its lifetime. When Foo dies, so does Bar

		public class Foo {
		    private Bar bar = new Bar(); 
		}
		Aggregation - I have an object which I've borrowed from someone else. When Foo dies, Bar may live on.

		public class Foo { 
		    private Bar bar; 
		    Foo(Bar bar) { 
		       this.bar = bar; 
		    }
		} */



// Comparable vs Comparator

class Movie implements Comparable<Movie>{
	private double rating;
    private String name;
    private int year;
	public double getRating() {
		return rating;
	}
	public String getName() {
		return name;
	}
	public int getYear() {
		return year;
	}
	 public Movie(String nm, double rt, int yr)
	    {
	        this.name = nm;
	        this.rating = rt;
	        this.year = yr;
	    }
	// compareTo -> Compares this object with the specified object for order. Returns a negative integer, zero, or a positive integer as this object is
	// less than, equal to, or greater than the specified object.
	@Override
	public int compareTo(Movie o) {
		// TODO Auto-generated method stub
		//return this.rating - o.rating; //Type mismatch: cannot convert from double to int
		return this.year - o.year; // since year is int
	}
}

class RatingCompare implements Comparator<Movie>{

	@Override
	public int compare(Movie m1, Movie m2) {
		// TODO Auto-generated method stub
		if (m1.getRating() < m2.getRating()) return -1;
        if (m1.getRating() > m2.getRating()) return 1;
        else return 0;
	}
	
}

class Basics {
	public static void main(String[] args) {
		ArrayList<Movie> list = new ArrayList<Movie>();
        list.add(new Movie("Force Awakens", 8.3, 2015));
        list.add(new Movie("Star Wars", 8.7, 1977));
        list.add(new Movie("Empire Strikes Back", 8.8, 1980));
        list.add(new Movie("Return of the Jedi", 8.4, 1983));
        
        //Comparable sort by year
        // sort -> Sorts the specified list into ascending order, according to the natural ordering of its elements.All elements in the list
        // must implement the Comparableinterface. Furthermore, all elements in the list must be mutually comparable (that is, e1.compareTo(e2)
        // must not throw a ClassCastException for any elements e1 and e2 in the list). 
        Collections.sort(list);
        System.out.println("******************sorted by year*********************888");
        list.stream().forEach((movie) -> {
        	System.out.println(movie.getName() + " " +
                    movie.getRating() + " " +
                    movie.getYear());
        });
        // System.out.println(list); // [questions.Movie@7de26db8, questions.Movie@1175e2db, questions.Movie@36aa7bc2, questions.Movie@76ccd017]
        // as Object is pass by reference
        
        Collections.sort(list,new RatingCompare());
        System.out.println("*****************8sorted by rating*******************");
        list.stream().forEach((movie) -> {
        	System.out.println(movie.getName() + " " +
                    movie.getRating() + " " +
                    movie.getYear());
        });
	}
}

/* String vs StringBuffer vs StringBuilder
 * String is immutable -> String Buffer & String Builder are mutable
 * StringBuffer is synchronized -> StringBuilder is non synchronized
 * 
 * Concat() method takes only one argument and concatenates with other string, creates a new string
 * + operator takes any number of argument and creates a new string
 * StringBuffer append() doesn't create a new string.
 * 
 * Immutable class are thread safe
 * How to create an immutable class in Java:::
 * - Class must be declared as final.
 * - Data members must be declared as final and private
 * - No setters
 * - A parameterised constructor should initialise all the fields performing a deep copy
 */

/* Fail fast and Fail safe iterator
 * n this article, I am going to explain how those collections behave which doesn’t iterate as fail-fast. First of all, 
 * there is no term as fail-safe given in many places as Java SE specifications does not use this term. 
 * I am using fail safe to segregate between Fail fast and Non fail-fast iterators.
Concurrent Modification: Concurrent Modification in programming means to modify an object concurrently when another task is 
already running over it. For example, in Java to modify a collection when another thread is iterating over it. 
Some Iterator implementations (including those of all the general purpose collection implementations provided by the JRE) may 
choose to throw ConcurrentModificationException if this behavior is detected.
 

Fail Fast And Fail Safe Iterators in Java

Iterators in java are used to iterate over the Collection objects.Fail-Fast iterators immediately throw ConcurrentModificationException 
if there is structural modification of the collection. Structural modification means adding, removing any element from collection while a 
thread is iterating over that collection. Iterator on ArrayList, HashMap classes are some examples of fail-fast Iterator.
Fail-Safe iterators don’t throw any exceptions if a collection is structurally modified while iterating over it. 
This is because, they operate on the clone of the collection, not on the original collection and that’s why they are called fail-safe 
iterators. Iterator on CopyOnWriteArrayList, ConcurrentHashMap classes are examples of fail-safe Iterator.

Fail Safe Iterator

First of all, there is no term as fail-safe given in many places as Java SE specifications does not use this term. I am using this term to demonstrate the difference between Fail Fast and Non-Fail Fast Iterator. These iterators make a copy of the internal collection (object array) and iterates over the copied collection. Any structural modification done to the iterator affects the copied collection, not original collection. So, original collection remains structurally unchanged. 
 

Fail-safe iterators allow modifications of a collection while iterating over it.
These iterators don’t throw any Exception if a collection is modified while iterating over it.
They use copy of original collection to traverse over the elements of the collection.
These iterators require extra memory for cloning of collection. Ex : ConcurrentHashMap, CopyOnWriteArrayList
*/