package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
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
    public static void main(String[] args) {
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

    }
}