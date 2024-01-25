# Q. static & default method in Interface.

Before Java 8, interfaces could have only public abstract methods. It was not possible to add new functionality to the existing interface without forcing all implementing classes to create an implementation of the new methods, nor was it possible to create interface methods with an implementation.

Starting with Java 8, interfaces can have static and default methods that, despite being declared in an interface, have a defined behavior.

### Static Method
Consider this method of the interface (let’s call this interface Vehicle):
```
static String producer() {
    return "N&F Vehicles";
}
```
The static producer() method is available only through and inside of an interface. It can’t be overridden by an implementing class.

To call it outside the interface, the standard approach for static method call should be used:

### Default Method
Default methods are declared using the new default keyword. These are accessible through the instance of the implementing class and can be overridden.

Let’s add a default method to our Vehicle interface, which will also make a call to the static method of this interface:
```
default String getOverview() {
    return "ATV made by " + producer();
}
```
Assume that this interface is implemented by the class VehicleImpl.

For executing the default method, an instance of this class should be created:
```
Vehicle vehicle = new VehicleImpl();
String overview = vehicle.getOverview();
```

### Method References
Method reference can be used as a shorter and more readable alternative for a lambda expression that only calls an existing method. There are four variants of method references.

Reference to a Static Method - ContainingClass::methodName

Reference to an Instance Method - containingInstance::methodName

Reference to an Instance Method of an Object of a Particular Type - ContainingType::methodName

Reference to a Constructor - ClassName::new


# Q. Optional<T>

An instance of the Optional class can be created with the help of its static methods.

Let’s look at how to return an empty Optional:
```
Optional<String> optional = Optional.empty();
```
Next, we return an Optional that contains a non-null value:
```
String str = "value";
Optional<String> optional = Optional.of(str);
```
Finally, here’s how to return an Optional with a specific value or an empty Optional if the parameter is null:
```
Optional<String> optional = Optional.ofNullable(getString());
```
