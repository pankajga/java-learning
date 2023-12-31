package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/* Simply put, streams are wrappers around a data source, allowing us to operate with that data source
and making bulk processing convenient and fast.

A stream does not store data and, in that sense, is not a data structure. It also never modifies the
underlying data source.
*/

class Employee {
    String name;
    String department;
    int salary;

    Employee(String name, String department, int salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

	Employee(String name, int salary, String department) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

	public int getSalary() {
		return this.salary;
	}

	public String getName() {
		return this.name;
	}

	public String getDepartment() {
		return this.department;
	}
}

public class StreamsAPI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Employee> list1 = Arrays.asList(
				new Employee("Pankaj", "Sales", 2000),
				new Employee("Ashu", "Sales", 5000),
				new Employee("Rahul", "HR", 9000),
				new Employee("Govind", "Finance", 1000),
				new Employee("Pankaj", "HR", 3000)
				);
		
		List<List<Employee>> list2 = Arrays.asList(
				Arrays.asList(new Employee("Pankaj", "Sales", 2000)),
				Arrays.asList(new Employee("Ashu", "Sales", 5000)),
				Arrays.asList(new Employee("Rahul", "HR", 9000)),
				Arrays.asList(new Employee("Govind", "Finance", 1000))
				);
		
		
		// Filter findFirst************************************************************
		
		String name = list1.stream()
				.filter(emp -> emp.getSalary() > 4000)
				.findFirst()
				.map(Employee::getName)
				.get();
		System.out.println(name); //Ashu
		
		
		// FlatMap**************************************************************************
		
		System.out.println(list2); //[[questions.Employee@27abe2cd], [questions.Employee@5f5a92bb], [questions.Employee@6fdb1f78], [questions.Employee@51016012]]
		List<Employee> flatList = list2.stream()
				.flatMap(Collection::stream)
				.collect(Collectors.toList());
		System.out.println(flatList); //[questions.Employee@27abe2cd, questions.Employee@5f5a92bb, questions.Employee@6fdb1f78, questions.Employee@51016012]
		
		
		// Group By Department***********************************************************************
		
		// Luckily, the second parameter of the overloaded Collectors#groupingBy method is another Collector, so it can simply be invoked twice.
		/* Map<String, Map<Integer, Set<Employee>>> map = myList.stream()
			    .collect(Collectors.groupingBy(Employee::getDepartmentId, 
			        Collectors.groupingBy(Employee::getEmployeeId, Collectors.toSet()))); */
		Map<String, List<Employee>> map1 = list1.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment));
		System.out.println(map1); //{Sales=[questions.Employee@12bc6874, questions.Employee@de0a01f], Finance=[questions.Employee@4c75cab9], HR=[questions.Employee@1ef7fe8e, questions.Employee@6f79caec]}
		
		
		// Skip Limit*****************************************************************************
		
		List<Integer> skipList = Arrays.asList(16, 32, 64, 128, 256);
		List<Integer> skip = skipList.stream()
				.skip(3)
				.collect(Collectors.toList());
		System.out.println(skip); //[128, 256]
		
		List<Integer> limit = skipList.stream()
				.skip(3)
				.limit(1)
				.collect(Collectors.toList());
		System.out.println(limit); //[128]
		
		
		// Sorted**********************************************************************************************
		
		List<String> sortedName = list1.stream()
				.sorted((e1,e2) -> e1.getName().compareTo(e2.getName()))
				.map(Employee::getName)
				.collect(Collectors.toList());
		
		System.out.println(sortedName); // [Ashu, Govind, Pankaj, Pankaj, Rahul]
		
		//Map<String, Integer> customMap = list1.stream()
		//		.collect(Collectors.toMap(Employee::getName, Employee::getSalary)); //Exception in thread "main" java.lang.IllegalStateException: Duplicate key Pankaj (attempted merging values 2000 and 3000)
		
		Map<Integer, String> customMap = list1.stream()
				.collect(Collectors.toMap(Employee::getSalary, Employee::getName));
		
		System.out.println(customMap); // {2000=Pankaj, 5000=Ashu, 9000=Rahul, 1000=Govind, 3000=Pankaj}
		
		
		// max*******************************************************************************************
		
		int maxSalary = list1.stream()
				.map(Employee::getSalary)
				.max(Comparator.comparing(Integer::intValue))
				.get();
		
		System.out.println(maxSalary); // 9000
		
		
		// distinct**************************************************************************************
		
		List<Integer> intList = Arrays.asList(2, 5, 3, 2, 4, 3);
		List<Integer> distinctlist = intList.stream()
				.distinct()
				.collect(Collectors.toList());
		
		System.out.println(distinctlist); //[2, 5, 3, 4]
		
		
		// allMatch anyMatch noneMatch**************************************************************************
		
		List<Integer> intList1 = Arrays.asList(2, 4, 5, 6, 8);
		
		boolean allMatch = intList1.stream()
				.allMatch(i -> i%2 == 0);
		
		boolean anyMatch = intList1.stream()
				.anyMatch(i -> i%2 == 0);
		
		boolean noneMatch = intList1.stream()
				.anyMatch(i -> i%3 == 0);
		
		System.out.println(allMatch); //false
		System.out.println(anyMatch); //true
		System.out.println(noneMatch); //truevv vvv  
		
		// top 3 highest salary earning employee*********************************************************************************
		
		List<String> empNames = list1.stream()
				.sorted(Comparator.comparing(Employee::getSalary).reversed())
				.limit(3)
				.map(Employee::getName)
				.collect(Collectors.toList());
		
		System.out.println(empNames); //[Rahul, Ashu, Pankaj]
		
		// Sequential vs Parallel stream
		
		/*Sequential Streams are non-parallel streams that use a single thread to process the pipelining. Any stream operation 
		 * without explicitly specified as parallel is treated as a sequential stream. Sequential stream’s objects are pipelined in a 
		 * single stream on the same processing system hence it never takes the advantage of the multi-core system even though the 
		 * underlying system supports parallel execution. Sequential stream performs operation one by one
		 * 
		 * It is a very useful feature of Java to use parallel processing, even if the whole program may not be parallelized. 
		 * Parallel stream leverage multi-core processors, which increases its performance. Using parallel streams, our code gets 
		 * divide into multiple streams which can be executed parallelly on separate cores of the system and the final result is shown 
		 * as the combination of all the individual core’s outcomes. It is always not necessary that the whole program be parallelized, 
		 * but at least some parts should be parallelized which handles the stream. The order of execution is not under our control and 
		 * can give us unpredictably unordered results and like any other parallel programming, they are complex and error-prone. 
		 * 
		 * Though parallel stream uses multiple core i.e. threads to execute, the order of execution is not know hence complex
		 * 
		 * https://www.geeksforgeeks.org/parallel-vs-sequential-stream-in-java/
		 * 
		 */



	String s1 = "sjxbwkch   ldcjbcjwb";
        String[] sa1 = s1.split("");
        Map<String, Integer> m1 = new HashMap<>();
        for(String s : sa1){
            if(s != " "){
                if(m1.get(s) != null){
                    int i = m1.get(s);
                    m1.put(s, i+1);
                }
                else {
                    m1.put(s, 1);
                }
            }
        }
        m1.forEach((k,v) -> {
            System.out.println(k+" -> "+v);
        });

        List<Employee> l1 = Arrays.asList(
            new Employee("Abhi", 123, "Developer"),
            new Employee("Ram", 345, "Tester"),
            new Employee("Shital", 245, "Manager"),
            new Employee("Sneha", 001, "Tester"),
            new Employee("Shubh", 378, "Developer")
        );
        
        //sort by name
        List<String> name1 = l1.stream().sorted((e1,e2) -> e1.name.compareTo(e2.name)).map(e -> e.name).collect(Collectors.toList());

        int max = l1.stream().map(e -> e.salary).max(Comparator.comparing(Integer::intValue)).get();

        Map<String, Integer> m2 = l1.stream().collect(Collectors.toMap((e)->e.name, (e)->e.salary));
        System.out.println(m2);
        String name2 = m2.entrySet().stream().filter(e -> e.getValue() > 300).map(e -> e.getKey()).findFirst().get();

        List<Integer> list3 = new ArrayList<>(Arrays.asList(2,5,1,3,0,9));
        System.out.println(list1);
        list1.remove(Integer.valueOf(9));
        System.out.println(list1);
        List<Integer> list11 = new ArrayList<>();
        list11.add(1);
        list11.add(2);
        list11.add(4);
        list11.add(3);
        int sum = list11.stream().mapToInt(Integer::intValue).sum();
        System.out.println("sum: "+sum); //sum: 11
        int sumr = list11.stream().reduce(0,(a,b)->a+b);
        System.out.println("sumr: "+sumr); //sumr: 10
        list11.stream().mapToInt(Integer::intValue).average().ifPresentOrElse((data) -> System.out.println("average is: "+data), 
            () -> System.out.println("no data")); //average is: 2.2

        Optional<Integer> optional = Optional.of(134);
        System.out.println("optional:"+optional); //optional:Optional[134]
    
//}

// class Employee {
//     String name;
//     int id;
//     String designation;

//     Employee(String name, int id, String designation){
//         this.name = name;
//         this.id = id;
//         this.designation = designation;
//     }
// }
		
		// create a list
        List<String> list23 = Arrays.asList("Hello ", 
                         "G", "E", "E", "K", "S!");
  
        // using parallelStream() 
        // method for parallel stream
        list23.parallelStream().forEach(System.out::print);  // ES!KGEHelloj; 
		
	}
}

//}

// class Employee {
// 	String name;
// 	String department;
// 	int salary;
// 	public Employee(String name, String department, int salary) {
// 		super();
// 		this.name = name;
// 		this.department = department;
// 		this.salary = salary;
// 	}
// 	public String getName() {
// 		return name;
// 	}
// 	public String getDepartment() {
// 		return department;
// 	}
// 	public int getSalary() {
// 		return salary;
// 	}
// }
