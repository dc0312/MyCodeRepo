package lambda.lambdaExpression;

import java.util.TreeSet;

class Employee implements Comparable{
    int id;
    String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return id +" : "+name;
    }

    @Override
    public int compareTo(Object o) {
        int id1 = this.id;
        Employee e = (Employee) o;
        int id2 = e.id;
        return id1 > id2 ? -1 : id1 < id2 ? 1 : 0;
    }
}
public class TreeSetMain {
    public static void main(String[] args) {
        Employee e1 = new Employee(1,"Deepak");
        Employee e2 = new Employee(2,"Aditya");

        TreeSet<Employee> set = new TreeSet<>();
        set.add(e1);
        set.add(e2);

        System.out.println(set);
    }
}
