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

