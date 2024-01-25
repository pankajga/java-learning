package streams;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.stream.Collectors;

class Employee1 {
    int id;
    String name;
    int salary;
    String department;

    Employee1(int id, String name, int salary, String department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
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

class Test {
    public static void main(String[] args) throws FileNotFoundException {
        //Employee1 e1 = new Employee1(1, "Ram", 1231, "Developer");
        List<Employee1> employeeList = Arrays.asList(
            new Employee1(1, "Ram", 1231, "Developer"),
            new Employee1(2, "Shyam", 3112, "HR"),
            new Employee1(3, "Shital", 213112, "Manager"),
            new Employee1(4, "Suresh", 2312, "Developer"),
            new Employee1(5, "Kishan", 2222, "HR")
        );
        //System.out.println(employeeList);
        List<String> sortedName = employeeList.stream().sorted((v1, v2) -> v1.name.compareTo(v2.name))
                                        .map(v -> v.name).collect(Collectors.toList());
        System.out.println("sortedName: "+sortedName);

        List<String> reverseSorted = employeeList.stream().sorted(Comparator.comparing(Employee1::getSalary).reversed())
                        .map(v -> v.name).collect(Collectors.toList());

        Map<String,Integer> map1 = employeeList.stream()
                .collect(Collectors.toMap(Employee1::getName, Employee1::getSalary));

        map1.forEach((k,v) -> {
            System.out.println("name:"+k+" salary:"+v);
        });

        List<String> salaryName = employeeList.stream()
                .filter(v -> v.getSalary()>10000)
                .map(emp -> emp.getName())
                .collect(Collectors.toList());

        Integer max = employeeList.stream().map(v -> v.getSalary()).max(Comparator.comparing(Integer::intValue)).get();
        System.out.println("max: "+max);



        Map<String, Integer> hmap = new HashMap<>();
        hmap.put("Pankaj", 1021);
        hmap.put("Gaurav", 121);
        hmap.put("Ram", 222);
        hmap.put("Suresh", 1111);
        hmap.put("Nikhil", 4444);
        hmap.put("Raj", 122);

        Map<String, Integer> lhmap = new HashMap<>();
        lhmap.put("Pankaj", 1021);
        lhmap.put("Gaurav", 121);
        lhmap.put("Ram", 222);
        lhmap.put("Suresh", 1111);
        lhmap.put("Nikhil", 4444);
        lhmap.put("Raj", 122);

        for(Entry<String, Integer> entry : hmap.entrySet()) {
            System.out.println("Key = " + entry.getKey() + 
                             ", Value = " + entry.getValue());
        }
        // Key = Quiz, Value = www.geeksforgeeks.org
        // Key = Practice, Value = practice.geeksforgeeks.org
        // Key = GFG, Value = geeksforgeeks.org
        // Key = Code, Value = code.geeksforgeeks.org

        Iterator<Entry<String, Integer>> itr = hmap.entrySet().iterator();
        while(itr.hasNext()) {
            Entry<String, Integer> entry = itr.next();
            System.out.println("Key = " + entry.getKey() +  
                                 ", Value = " + entry.getValue()); 
        }

        Map<String,Integer> mapy = hmap.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(e1, e2) -> e1, LinkedHashMap::new));

        System.out.println("mapy: "+mapy);
        // we needed to store the above in a new linked hashmap as hashmap doesnt maintain insertion order.

        Map<String, Integer> hmapy = lhmap.entrySet().stream()
            .sorted(Comparator.comparing(Map.Entry::getValue))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1,e2)-> e1, LinkedHashMap::new));
        System.out.println("hmapy: "+hmapy);


        //Read a file
        File myFile = new File("filename.txt");
        Scanner myScanner = new Scanner(myFile);
        while(myScanner.hasNextLine()){
            String data = myScanner.nextLine();
        }
    }
}