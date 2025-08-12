### Autoboxing vs Unboxing in Java ?
Autoboxing is the automatic conversion of a primitive type (like int, char, double) into its corresponding wrapper class (Integer, Character, Double, etc.).
```
int num = 10;
Integer boxedNum = num; // Autoboxing: int → Integer
```

Unboxing is the reverse process: converting a wrapper class object back into its primitive type.
```
Integer boxedNum = Integer.valueOf(20);
int num = boxedNum; // Unboxing: Integer → int
```

### what is load factor in a hashmap ?
The load factor in a Java HashMap is a measure that determines when the capacity of the map should be increased to maintain efficient performance.

⚙️ Definition
The load factor is the ratio of the number of entries (key-value pairs) to the number of buckets (capacity).
It helps decide when to trigger rehashing—i.e., resizing the internal array and redistributing entries.
Load Factor = Number of Entries / Number of Buckets



📌 Default Value
- The default load factor is 0.75f (or 75%).
- This means: when the map is 75% full, it will resize (typically doubling the number of buckets).
Example:
If initial capacity is 16, then:
- Threshold = 16 * 0.75 = 12
- After inserting the 13th entry, the map resizes to 32 buckets.

🧠 Why It Matters
- Lower load factor (e.g., 0.5) → fewer collisions, faster access, but more memory usage.
- Higher load factor (e.g., 0.9) → better memory usage, but more collisions and slower access.

🛠️ Customizing Load Factor
You can set it explicitly when creating a HashMap:
Map<String, String> map = new HashMap<>(initialCapacity, loadFactor);


Example:
HashMap<String, Integer> map = new HashMap<>(32, 0.5f);



🚨 Performance Tip
A well-chosen load factor balances time complexity and space efficiency. The default 0.75f is a good compromise for most use cases.

### HashTable vs ConcurrentHashMap ?
🧵 Thread Safety
| Feature          | Hashtable                           | ConcurrentHashMap                                | 
| Synchronization  | Entire map is locked (method-level) | Fine-grained locking (bucket/segment level)      | 
| Read operations  | Blocked during write                | Fully concurrent reads                           | 
| Write operations | One thread at a time                | Multiple threads can write to different segments | 

🧠 Analogy
Think of:
- Hashtable as locking the entire house when one person enters.
- ConcurrentHashMap as locking individual rooms, allowing multiple people to work in parallel.

### What Is a Sealed Class?
A sealed class restricts which other classes can extend or implement it.
This is useful when you want to model a closed hierarchy—only a known set of subclasses should be allowed.

🧱 Syntax
```
public sealed class Vehicle permits Car, Truck {
    // common behavior
}

final class Car extends Vehicle {
    // specific to Car
}

non-sealed class Truck extends Vehicle {
    // Truck can be extended further
}
```

- sealed: Declares the base class/interface.
- permits: Lists allowed subclasses.
- Subclasses must be either:
- final (cannot be extended),
- sealed (further restricts inheritance),
- non-sealed (open for extension).

🎯 Why Use Sealed Classes?
- ✅ Encapsulation: Prevents unintended subclassing.
- ✅ Exhaustive handling: Useful in switch expressions with pattern matching.
- ✅ Domain modeling: Clearly defines all valid types in a hierarchy.
- ✅ Security: Limits exposure of internal APIs.

📦 Packaging Rules
- All permitted subclasses must be in the same module or same package.
- If all subclasses are in the same .java file, the permits clause can be omitted.

🧠 Use Case Example
Imagine modeling a payment system:
```
public sealed interface Payment permits CreditCard, UPI, NetBanking {}

final class CreditCard implements Payment {}
final class UPI implements Payment {}
final class NetBanking implements Payment {}
```
This ensures only these three types can represent a Payment.

### Cloneable deep clone vs shallow clone ?
🧬 Shallow Clone
A shallow clone creates a new object, but copies references to the nested objects rather than duplicating them.
🔍 Characteristics:
- Only the top-level object is duplicated.
- Nested objects (fields that are references) still point to the same memory.
- Changes to nested objects in the clone affect the original.
🧪 Example:
```
class Department {
    String name;
}

class Employee implements Cloneable {
    int id;
    Department dept;

    public Object clone() throws CloneNotSupportedException {
        return super.clone(); // shallow copy
    }
}
```

If you clone Employee, both original and clone share the same Department object.

🧬 Deep Clone
A deep clone creates a new object and also recursively clones all nested objects, resulting in a fully independent copy.
🔍 Characteristics:
- Entire object graph is duplicated.
- Changes in the clone do not affect the original.
- Requires manual cloning of nested objects.
🧪 Example:
```
class Department implements Cloneable {
    String name;

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Employee implements Cloneable {
    int id;
    Department dept;

    public Object clone() throws CloneNotSupportedException {
        Employee cloned = (Employee) super.clone();
        cloned.dept = (Department) dept.clone(); // deep copy
        return cloned;
    }
}
```

Now Employee and its Department are both independently cloned.

### 🔄 Java Thread Lifecycle States ?
Java defines the following six states for a thread, as per java.lang.Thread.State enum:
| State         | Description | 
| NEW           | Thread is created but not yet started. | 
| RUNNABLE      | Thread is ready to run or running. The JVM's thread scheduler decides when it gets CPU time. | 
| BLOCKED       | Thread is waiting to acquire a lock to enter a synchronized block/method. | 
| WAITING       | Thread is waiting indefinitely for another thread to perform a specific action (e.g., wait(), join()). | 
| TIMED_WAITING | Thread is waiting for a specified time (e.g., sleep(), join(timeout), wait(timeout)). | 
| TERMINATED    | Thread has completed execution or was terminated due to an error. | 

### 🧵 What Is ThreadLocal in Java?
ThreadLocal is a special class in Java that allows you to create variables that are local to a thread. Each thread accessing a ThreadLocal variable has its own independent copy, which is not shared with other threads.

🔍 Key Characteristics
- Thread confinement: Data stored in a ThreadLocal is accessible only by the thread that set it.
- No synchronization needed: Since each thread has its own copy, there's no need for locks.
- Used for per-thread state: Common in frameworks for storing user sessions, database connections, or transaction contexts.

🧪 Example
```
ThreadLocal<Integer> threadLocalValue = ThreadLocal.withInitial(() -> 1);

threadLocalValue.set(100); // Set value for current thread
int value = threadLocalValue.get(); // Get value for current thread
System.out.println(value); // Output: 100

threadLocalValue.remove(); // Clears the value for current thread
```

Each thread calling get() will see its own value, not the value set by another thread.

### what is a servlet ?
A servlet is a Java class used to extend the capabilities of servers that host applications accessed via a request-response model. It’s a core component of Java EE (Jakarta EE now) and is primarily used to build web applications.
Here’s a breakdown to make it crystal clear:

🌐 What a Servlet Does
- Receives HTTP requests from clients (usually browsers)
- Processes the request (e.g., reads parameters, interacts with databases)
- Generates a response, typically in HTML, JSON, or XML
- Sends the response back to the client

- If you're working with Spring Boot, servlets are often abstracted away, but understanding them gives you a solid grasp of how web apps work under the hood.
- 🧠 Think of servlets as the raw engine, and REST controllers as the polished dashboard.















