package hashMapSorting;

import java.util.Objects;
import java.util.TreeSet;
class Employee {
    String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

public class TreeSetMain {

    public static void main(String[] args) {
        //Employee e1 = new Employee("Deepak");
        //Employee e2 = new Employee("Aditya");

        TreeSet treeSet = new TreeSet((o1,o2)->{
            return -((Integer)o1).compareTo((Integer) o2);
        });

        treeSet.add(new Integer(20));
        treeSet.add(new Integer(10));
        System.out.println(treeSet);
    }
}
