# Q. How are Java Objects Stored in Memory? And What are the Stak and the Heap?
To run an application in an optimal way, JVM divides memory into stack and heap memory. Whenever we declare new variables and objects, call a new method, declare a String, or perform similar operations, JVM designates memory to these operations from either Stack Memory or Heap Space.

Class is a user-defined data type that is naturally used to declare objects of that type. The object is a real-world entity having a set of attributes and behavior. However, the object can’t be simply declared as same as primitive types.

### How are Java Objects Stored in Memory?
In Java, all objects are dynamically allocated on Heap. This is different from C++ where objects can be allocated memory either on Stack or on Heap. In JAVA, when we allocate the object using the "new keyword", the object is allocated on Heap, otherwise on Stack if not global or static.

When we only declare a variable of a class type, only a reference is created (memory is not allocated for the object). To allocate memory to an object, we must use the "new keyword". So the object is always allocated memory on the heap.

The creation of an object is a two-step procedure where we first declare an object of that class type and then a physical copy of the actual object of the class is assigned to that variable.

This assignment of an actual copy of the object is done by using the "new keyword"  for the dynamic allocation of memory. A "new keyword" allocates memory in the heap and the reference to the allocated object is nothing but an address stored in the variable of the respective reference type.
```
MyClass obj;
obj = new MyClass();
```
A reference variable is created and used to store the address of an object.
A "new keyword" paired with a constructor is used to assign the reference variable, this is how instantiation and initialization of an object take place. Instantiation of an object is done by new, whereas Initialization is done by the constructor of that class. A constructor initializes the newly created objects.

An object gets memory on the heap. In stack memory, the variable of class type stores the address of that object.

In heap memory, a physical copy of an object is stored, and the reference or address of this copy is in the variable of the associated class. Objects that can no longer be referenced are cleaned up by the Garbage collector.


### Stack Memory in Java
Stack Memory in Java is used for static memory allocation and the execution of a thread.
It contains primitive values that are specific to a method and references to objects referred from the method that are in a heap.
Access to this memory is in Last-In-First-Out (LIFO) order. Whenever we call a new method, a new block is created on top of the stack which contains values specific to that method, like primitive variables and references to objects.
When the method finishes execution, its corresponding stack frame is flushed, the flow goes back to the calling method, and space becomes available for the next method.


### Heap Space in Java
Heap space is used for the dynamic memory allocation of Java objects and JRE classes at runtime. New objects are always created in heap space, and the references to these objects are stored in stack memory.
These objects have global access and we can access them from anywhere in the application.
We can break this memory model down into smaller parts, called generations, which are:
Young Generation – this is where all new objects are allocated and aged. A minor Garbage collection occurs when this fills up.
Old or Tenured Generation – this is where long-surviving objects are stored. When objects are stored in the Young Generation, a threshold for the object's age is set, and when that threshold is reached, the object is moved to the old generation.
Permanent Generation – this consists of JVM metadata for the runtime classes and application methods.


### Stack
- Stack Memory in Java is used for static memory allocation and the execution of a thread.
- It's automatically allocated and deallocated when the method finishes execution.
- Access to this memory is fast when compared to heap memory.
- This memory is threadsafe, as each thread operates in its own stack.

### Heap
- Heap space is used for the dynamic memory allocation of Java objects and JRE classes at runtime. 
- Access to this memory is comparatively slower than stack memory.
- This memory, in contrast to stack, isn't automatically deallocated. It needs Garbage Collector to free up unused objects so as to keep the efficiency of the memory usage.
- Unlike stack, a heap isn't threadsafe and needs to be guarded by properly synchronizing the code.