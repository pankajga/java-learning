package questions;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SecondLargest {
	
	public static void findSecondLargest(ArrayList<Integer> list) {
		LocalTime startTime = LocalTime.now();
		int max = 0;
		int secondMax = 0;
		for(int i=0; i<list.size(); i++) {
			if(list.get(i) > max) {
				max = list.get(i);
			}
			else if(list.get(i) < max && list.get(i) > secondMax) {
				secondMax = list.get(i);
			}
		}
		System.out.println(secondMax);
		LocalTime endTime = LocalTime.now();
		Duration duration = Duration.between(startTime, endTime);
		System.out.println(duration.getNano()); //996800ns
		
	}
	
	public static void findSecondLargestUsingJava8(ArrayList<Integer> list) {
		// Execution - start time
        LocalTime startTime = LocalTime.now();
		//int max = list.stream().mapToInt(v -> v).max().getAsInt();
        
        int secondmax = list.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.println(secondmax);
		
		// Execution - end time
        LocalTime endTime = LocalTime.now();
 
        // find difference
        Duration duration = Duration.between(startTime, endTime);
        long differenceInNano = duration.getNano();
     
        // print execution time in Nano seconds
        System.out.println("\nExecution time - "
                + differenceInNano + " ns");  // 65156600ns
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<>();
		list.add(28);
		list.add(0);
		list.add(4);
		list.add(4);
		list.add(0);
		SecondLargest.findSecondLargest(list);
		//SecondLargest.findSecondLargestUsingJava8(list);
		
		Integer i = 2;
		@SuppressWarnings("removal")
		Integer j = new Integer(3);
		String s = "Pankaj";
		String s1 = new String("Pankaj");
		//System.out.println(i); // 2
		//System.out.println(j); // 3
		//System.out.println(s); // Pankaj
		//System.out.println(s1); // Pankaj
		
		ArrayList<Integer> list1 = new ArrayList<>();
		list1.add(28);
		list1.add(0);
		list1.add(4);
		list1.add(4);
		list1.add(0);
		//System.out.println(list1); //[28, 0, 4, 4, 0]
		
		ArrayList<String> list2 = new ArrayList<>();
		list2.add("Pankaj");
		list2.add("Ashu");
		list2.add("Rahul");
		list2.add("Govind");
		//System.out.println(list2); //[Pankaj, Ashu, Rahul, Govind] // syso of arraylist of custom object like Movie will return [@ss. #ddd, @we]
		// this is because Movie is object and you need to override the toString method to print the value
//The interface List does not define a contract for toString(), but the AbstractCollection base class provides a useful implementation that ArrayList inherits.
		int[] intArr = {2,3,5,6};
		//System.out.println(intArr); //[I@cac736f
		//System.out.println(Arrays.toString(intArr)); //[2, 3, 5, 6]
		// Explanation below***************************************************************
		/*When you print an array behind the scenes the method toString() is being called(as array is object) and it doesn't 
		print the content of the array (which is too bad IMO). But you can easily get over it using the library Arrays:

		System.out.println(Arrays.toString(list));*/
		
		

	}

}
