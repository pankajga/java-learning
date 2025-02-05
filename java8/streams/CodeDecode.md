Top 20 Java 8 Stream Api Operations
DocCanvas

Top 20 Java 8 Stream Api Operations
     

In java 8 coding interview, there can be a tricky question that we might not be able to solve if we don't know all possible operations available

So today we will see all such operations and there usages so that we can apply them on the go. This can help in understanding their usage and implications.

Certainly! Below is a list of Java 8 Stream API operations, each with a question focusing on 

achieving a specific goal using the operation, followed by the solution. This format will help in understanding how to use each operation effectively.



it is an intermediate operation.

1. filter 
Question:  Filter numbers greater than 5

Solution:

List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
List<Integer> result =    numbers.stream().filter(i=i>5).collect(collectors.toList)

2. map  
Question: Transform a list of strings into a list of their uppercase versions.

Solution:

List<String> words = Arrays.asList("apple", "banana", "cherry");
List<String> result = words.stream()
                           .map(String::toUpperCase)
                           .collect(Collectors.toList());
+// result: ["APPLE", "BANANA", "CHERRY"]

3. flatMap  
Question: Given a list of lists of strings, flatten them into a single list of strings.

Solution:

List<List<String>> listOfLists = Arrays.asList(
    Arrays.asList("one", "two"),
    Arrays.asList("three", "four")
);
List<String> result = listOfLists.stream()
                                 .flatMap(Collection::stream)
                                 .collect(Collectors.toList());
// result: ["one", "two", "three", "four"]

Some real time example:

class Order {

    private List<Item> items;

    // other fields and methods



    public List<Item> getItems() {

        return items;

    } 

}



class Item {

    private String name;

    // other fields and methods



    public String getName() {

        return name;

    }

}

import java.util.List;

import java.util.stream.Collectors;



public class OrderService {



    public List<Item> getAllItems(List<Order> orders) {

        return orders.stream()

                .flatMap(order -> order.getItems().stream()) // Flattening List<Item>

                .collect(Collectors.toList());

    }

}


Flatten Items: Use flatMap to transform each Order into a stream of its Item objects. This operation "flattens" the nested structure, converting a Stream<List<Item>> into a Stream<Item>.



4. distinct  
Question: Remove duplicates from a list of integers.

Solution:

 List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 3, 4);
List<Integer> result = numbers.stream()
                              .distinct()
                              .collect(Collectors.toList());
// result: [1, 2, 3, 4]


5. sorted  
Question: Sort a list of names in reverse alphabetical order.

Solution: 

   List<String> names = Arrays.asList("John", "Jane", "Alice", "Bob");
List<String> result = names.stream()
                           .sorted(Comparator.reverseOrder())
                           .collect(Collectors.toList());
// result: ["John", "Jane", "Bob", "Alice"]



6. peek 
Question: Print each element in a list while converting them to uppercase.

Solution:

List<String> words = Arrays.asList("apple", "banana", "cherry");
List<String> result = words.stream()
                           .peek(word -> System.out.println("Original: " + word))
                           .map(String::toUpperCase)
                           .collect(Collectors.toList());
// Console output: Original: apple, Original: banana, Original: cherry
// result: ["APPLE", "BANANA", "CHERRY"]

The peek method in Java Streams is primarily used for debugging purposes. It allows you to perform an intermediate operation on each element of the stream without modifying the stream itself.

peek: The peek method is applied to the stream. It prints each word with the prefix "Original: ". The output of this method does not modify the elements; it only performs a side action (printing in this case).



7. limit  
Question: Fetch the first 3 elements from a list of integers.

Solution:

List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
List<Integer> result = numbers.stream()
                              .limit(3)
                              .collect(Collectors.toList());
// result: [1, 2, 3]

8. skip  
Question: Skip the first 4 elements and fetch the remaining elements from a list of integers.

Solution:

List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
List<Integer> result = numbers.stream()
                              .skip(4)
                              .collect(Collectors.toList());
// result: [5, 6, 7, 8, 9, 10]



9. forEach  ﻿ 

Question: Print each element of a list of strings with the prefix "Item: ".

Solution:

List<String> words = Arrays.asList("apple", "banana", "cherry");
words.stream()
     .forEach(word -> System.out.println("Item: " + word));
// Console output: Item: apple, Item: banana, Item: cherry

10. collect  
Question: Collect a list of integers into a Set.

Solution:

List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 4, 5);
Set<Integer> result = numbers.stream()
                             .collect(Collectors.toSet());
// result: [1, 2, 3, 4, 5]

11. reduce  
Question: Compute the product of all numbers in a list.

Solution:

List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
Optional<Integer> result = numbers.stream()
                                   .reduce((a, b) -> a * b);
// result: Optional[120]



The reduce method in Java Streams is used to perform a reduction on the elements of a stream, combining them into a single result. It applies a binary operation (a function that takes two arguments and returns a single result) to the elements of the stream, repeatedly, until all elements have been processed and a single value remains.

Steps of Reduction:

Start with the first two elements: 1 * 2 = 2 
Multiply the result with the next element: 2 * 3 = 6 
Multiply the result with the next element: 6 * 4 = 24  
Multiply the result with the last element: 24 * 5 = 120  




12. allMatch  


The allMatch method in Java Streams is used to check if all elements in the stream satisfy a given predicate. It returns true if every element in the stream matches the predicate, and false otherwise.

Short-Circuiting: The allMatch operation is short-circuiting, meaning it stops processing as soon as it finds the first element that does not match the predicate. If it finds such an element, it immediately returns false.



Question: Check if all numbers in a list are positive.

Solution:

List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
boolean result = numbers.stream()
                        .allMatch(n -> n > 0);
// result: true



13. anyMatch  
The anyMatch method checks whether at least one element in the stream matches a given predicate. It returns true as soon as it finds an element that satisfies the predicate and stops further processing. If no elements match, it returns false 



﻿anyMatch is short-circuiting, meaning it stops processing as soon as it finds the first element that matches the predicate, optimizing performance.

 

Question: Check if any number in a list is greater than 10.

Solution:

List<Integer> numbers = Arrays.asList(5, 8, 12, 3);
boolean result = numbers.stream()
                          .anyMatch(n -> n > 10);
// result: true

14. noneMatch  


The noneMatch method in Java Streams is used to check if no elements in the stream match a given predicate. It returns true if none of the elements satisfy the predicate and false if at least one element does.

 Like allMatch and anyMatch, noneMatch is short-circuiting. It stops processing as soon as it finds the first element that matches the predicate and immediately returns false 



Question: Check if no elements in a list are negative.

Solution:

List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
boolean result = numbers.stream()
                        .noneMatch(n -> n < 0);
// result: true



15. findFirst  
 is used to retrieve the first element in a stream that matches a given condition or simply the first element in the stream if no filtering is applied. It returns the first element wrapped in an Optional, which is a container object that may or may not contain a non-null value.

﻿findFirst is a short-circuiting operation, meaning it stops processing as soon as it finds the first element, optimizing performance



Question: Find the first element in a list that starts with the letter 'b'.

Solution:

List<String> words = Arrays.asList("apple", "banana", "cherry");
Optional<String> result = words.stream()
                               .filter(word -> word.startsWith("b"))
                               .findFirst();
// result: Optional[banana]



16. findAny  
retrieve any element from the stream that matches a given condition, or simply any element from the stream if no filtering is applied. It returns the element wrapped in an Optional, which may or may not contain a value.

﻿findAny is a short-circuiting operation, meaning it stops processing as soon as it finds any element that satisfies the condition, improving performance.

Question: Find any element in a list that starts with the letter 'c'.

Solution:

List<String> words = Arrays.asList("apple", "banana", "cherry");
Optional<String> result = words.stream()
                               .filter(word -> word.startsWith("c"))
                               .findAny();
// result: Optional[cherry]



17. max and min  
used to find the maximum and minimum elements in a stream, respectively, based on a given comparator or natural ordering. These methods return an Optional because the stream might be empty.

Return Type: Both methods return an Optional<T> to handle the case where the stream might be empty.



Question: Find the maximum and minimum value from a list of integers.

Solution:

List<Integer> numbers = Arrays.asList(5, 1, 8, 3, 9);
Optional<Integer> max = numbers.stream()
                               .max(Integer::compareTo);
// max: Optional[9]

Optional<Integer> min = numbers.stream()
                               .min(Integer::compareTo);
// min: Optional[1]



18. toArray  
Question: Convert a list of strings into an array.

Solution:

List<String> words = Arrays.asList("apple", "banana", "cherry");
String[] result = words.stream()
                       .toArray(String[]::new);
// result: ["apple", "banana", "cherry"]

19. joining  
 is used to concatenate the elements of a stream into a single String. It’s part of the  utility class and provides a convenient way to aggregate elements into a string format with optional delimiters, prefixes, and suffixes.



joining(CharSequence delimiter, CharSequence prefix, CharSequence suffix)



Question: Concatenate all strings in a list into a single string separated by commas.



Solution:

List<String> words = Arrays.asList("apple", "banana", "cherry");
String result = words.stream()
                     .collect(Collectors.joining(", "));
// result: "apple, banana, cherry"

String result = words.stream()
                     .collect(Collectors.joining(", ", "[", "]"));
 // result: "[Apple, Banana, Cherry]"


20. groupingBy  
group elements of the stream by a specified classifier function. It is a powerful feature provided by the Collectors utility class and is commonly used for aggregating and categorizing data into a Map where the keys are the result of applying the classifier function and the values are lists of items corresponding to each key.



Question: Group a list of people by their city.

Solution:

Map<String, String> cityMap = new HashMap<>();
cityMap.put("max","dallas");
cityMap.put("john","houston");
cityMap.put("mike", "dallas");
cityMap.put("eric","austin");
cityMap.put("matt","austin");

cityMap.entrySet().stream().collect(Collectors.groupingBy(Map.Entry::getValue , Collectors.mapping(Map.Entry::getKey,Collectors.toList())));

//result: {dallas=[max, mike], houston=[john], austin=[matt, eric]}



 










