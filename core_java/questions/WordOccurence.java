package questions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordOccurence {
	
	// Function.identity()  --> Returns a function that always returns its input argument.
	// Collectors.counting() --> Returns a Collector accepting elements of type T that counts the number of input elements. If no elements are present, the result is 0.
	static void occurenceUsingJava8(String word) {
		String[] sa = word.split("");
		Map<String, Long> resultMap = Arrays.stream(sa).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		resultMap.entrySet().stream().forEach(System.out::println);
	}
	
	static void occurence(String word) {
		HashMap<String, Integer> countMap = new HashMap<>();
		String[] sa = word.split("");
		for(String s : sa) {
			if(!s.equals(" ")) {
				if(countMap.get(s) != null) {
					int count = countMap.get(s);
					countMap.put(s, count+1);
				}
				else {
					countMap.put(s, 1);
				}
			}
		}
		countMap.forEach((k,v) -> {
			System.out.println(k+" - "+v);
		});
	}
	
	public static void findDuplicate(String word) {
		HashSet<String> set1 = new HashSet<>();
		String[] sa1 = word.split("");
		for(String s : sa1) {
			if(!s.equals(" ")) {
				if(set1.add(s)) {}
				else {
					System.out.println(s);
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//WordOccurence.findDuplicate(" aabd 12 ddwb");
		//WordOccurence.occurence(" aabd 12 ddwb");
		WordOccurence.occurenceUsingJava8(" aabd 12 ddwb");
	}

}
