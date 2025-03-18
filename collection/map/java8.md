## Merge function 
The `merge` function in Java's `Map` interface is a powerful method introduced in Java 8. It allows you to combine a key-value pair into the map and resolve conflicts if the key already exists. Here's how it works:

### Syntax:
```java
default V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction)
```

- `key`: The key whose associated value is to be merged.
- `value`: The value to be merged.
- `remappingFunction`: A function that takes the old value (if present) and the new value, and computes a resulting value.

### How it works:
1. If the key is not already associated with a value or the value is `null`, the `merge` method adds the new value to the map.
2. If the key is associated with a non-`null` value, the `remappingFunction` is applied to compute a new value. If the computed value is `null`, the key is removed from the map.

### Example:
```java
import java.util.HashMap;
import java.util.Map;

public class MergeExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        map.put("A", 1);
        map.put("B", 2);

        // Merging when the key exists
        map.merge("A", 3, (oldValue, newValue) -> oldValue + newValue);

        // Merging when the key does not exist
        map.merge("C", 5, (oldValue, newValue) -> oldValue + newValue);

        System.out.println(map); // Output: {A=4, B=2, C=5}
    }
}
```

### Key Points:
- Simplifies updating or merging map values.
- Handles `null` values gracefully.
- Useful for building or modifying maps in a functional style.

## putIfAbsent

The `putIfAbsent` method in Java's `Map` interface is another handy tool introduced in Java 8. It allows you to add a key-value pair to the map only if the key is not already associated with a value (or if its value is `null`).

### Syntax:
```java
default V putIfAbsent(K key, V value)
```

- `key`: The key to be added.
- `value`: The value to be added if the key is not already mapped.

### Behavior:
1. If the key is not present in the map, or if it's associated with a `null` value, the method inserts the key-value pair and returns `null`.
2. If the key already exists with a non-`null` value, the method does nothing and simply returns the existing value.

### Example:
```java
import java.util.HashMap;
import java.util.Map;

public class PutIfAbsentExample {
    public static void main(String[] args) {
            Map<String, String> map = new HashMap<>();

                    map.put("A", "Apple");
                            map.put("B", "Banana");

                                    // This key already exists, so nothing will be changed
                                            map.putIfAbsent("A", "Apricot");

                                                    // This key does not exist, so it will be added
                                                            map.putIfAbsent("C", "Cherry");

                                                                    System.out.println(map); // Output: {A=Apple, B=Banana, C=Cherry}
                                                                        }
                                                                        }
                                                                        ```

                                                                        ### Use Case:
                                                                        The `putIfAbsent` method is particularly useful in scenarios where you want to ensure that a default value is set for a key only if no value currently exists for that key. It's a clean and thread-safe way to avoid overwriting existing mappings.

                                                            
## computeIfPresent

The `computeIfPresent` method in Java's `Map` interface is a functional way to update a value in the map for a given key, but only if that key is already associated with a non-`null` value. It was introduced in Java 8 and is particularly useful for in-place transformations of map values.

### Syntax:
```java
default V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction)
```

- `key`: The key for which the value needs to be updated.
- `remappingFunction`: A function that takes the key and its associated value, and computes a new value.

### Behavior:
1. If the key is present and the associated value is non-`null`, the `remappingFunction` is applied to compute a new value.
2. If the result of the `remappingFunction` is non-`null`, the key is updated with the new value.
3. If the result of the `remappingFunction` is `null`, the key-value pair is removed from the map.

### Example:
```java
import java.util.HashMap;
import java.util.Map;

public class ComputeIfPresentExample {
    public static void main(String[] args) {
            Map<String, Integer> map = new HashMap<>();

                    map.put("A", 1);
                            map.put("B", 2);

                                    // Update the value for key "A" if present
                                            map.computeIfPresent("A", (key, value) -> value * 2);

                                                    // Attempt to update value for key "C" (which is not present)
                                                            map.computeIfPresent("C", (key, value) -> value * 2);

                                                                    System.out.println(map); // Output: {A=2, B=2}
                                                                        }
                                                                        }
                                                                        ```

                                                                        ### Use Case:
                                                                        - This method is ideal for conditional updates where a transformation of the existing value is needed.
                                                                        - It avoids the need for explicit `if` checks, making the code cleaner and more functional.

                                                                

