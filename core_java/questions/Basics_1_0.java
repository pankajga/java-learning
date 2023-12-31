package questions;

/*Why need interface if there is Abstract class?
 * => The short answer: An abstract class allows you to create functionality that subclasses can implement or override. 
 * An interface only allows you to define functionality, not implement it. And whereas a class can extend only one abstract class, 
 * it can take advantage of multiple interfaces.

 * Why Pointers are Eliminated in Java? (Answer)
Explain about Thread Life Cycle? (answer)
What is meant by Externalisation in Java? (answer)

Java serialization is not much effective when we have bloated objects with multiple attributes and 
properties. Here, externalization comes into role. It allows us o customize the serialization. 
For example, if we have implemented the Serialization interface in a class, we can externalize it 
using the writeExternal() method. When users reconstruct an externalized object from their end, 
an instance of the object will be created using the readExternal() method.

Thus, the externalization provides custom serialization, where we can manage our object stream and 
decide what to store in it.

The externalization is useful if we want to serialize a part of an object. We can serialize only 
the required fields of an object.

public class User implements Externalizable {  
    private String name;  
    private int age;  
    public User(){}  
    public User(String userName,int age){  
        this.name= userName;  
        this.age=age;  
    }  
    @Override  
    public void readExternal(ObjectInput in) throws IOException,ClassNotFoundException {  
        name=(String) in.readObject();  
        age=in.readInt();  
    }  
    @Override  
    public void writeExternal(ObjectOutput out) throws IOException {  
        out.writeObject(name);  
        out.writeInt(age);  
    }  
      
    public String getUserName() {  
        return name;  
    }  
    public void setUserName(String userName) {  
        this.name = userName;  
    }  
    public int getAge() {  
        return age;  
    }  
    public void setAge(int age) {  
        this.age = age;  
    }  
}  

public class JTPMain {  
       public static void main(String... args) throws Exception, IOException{  
           File f= new File("Test.txt");  
           User u= new User("JavaTpoint",25);  
           ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));    
           out.writeObject(u);    
           ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));  
           u=(User)in.readObject();  
           System.out.println("After De externalization username: " +u.getUserName()+" and age is:"+u.getAge());     
       }  
    }  

    https://www.javatpoint.com/externalization-in-java


What is your idea about Reflection Api?
What are the different types of Garbage Collection? (answer)
What is the difference between Comparable and Comparator Interface? (answer)
Do you have any work experience in Executor Services? (answer)
Difference between Callable and Runnable and Future? (answer)
A callable interface throws the checked exception and returns the result. 
A runnable interface, on the other hand, does not return a result and cannot throw a checked exception.

What are the Java 8 Features? (answer)
What is the advancement made in Hashmap in Java 8? (Answer)
Do you have any idea about Thread Dump and how is it created?
What are the different types of Thread pool creation in Concurrency Control? (Answer)
Difference between Volatile and Transient Keyword? (Answer)
Difference between Collection and Collections? (Answer)
What is Serialization? How Can we avoid Serialization of any fields or methods in a class? (Answer)
What is the use of Optional Class?
Difference between Map and FlatMap?
What do you understand about Functional Interface and some functional Interfaces? (answer)
What are the four main Functional Interface used in Java 8? (answer)
What do you understand about Marker Interface and some example for Marker Interface? (answer)
What is the difference between Fail-fast and Fail-Safe, Throw and Throws, StringBuffer and StringBuilder, Shallow copy and Deep copy, Finally vs final vs Finalize, String pool vs Heap?
When creating a string with new keyword where the object of created? (answer)
Idea about var args, Hashcode and Equals, Streams vs Collections?
Try with Resources, Object class Methods, Default size of ArrayList etc.?
What will happen if we try to remove any element from list without adding into it? eg List.remove(0) ?
what will happen if we execute the following statement
int a = Integer.parseInt(�text�); (Answer)*/

public class Basics_1_0 {

}
