package com.dc.data.structures.linkList;

class Link{
    public Employee employee;
    public Link next;

    public Link(Employee employee) {
        this.employee = employee;
    }

    public void displayLink(){
        System.out.print(employee.getFirstName() + " "+ employee.getLastName() +" -> " );
    }

    @Override
    public String toString() {
        return employee.getFirstName() +" "+employee.getLastName();
    }
}

class LinkedList{
    private Link first;

    public LinkedList(){
        first =null;
    }

    public void display(){
        Link currLink = first;

        while(null != currLink){
            currLink.displayLink();
            currLink = currLink.next;
        }
        System.out.println("");
    }

    public void insertFirst(Employee employee){
        Link newLink = new Link(employee);
        newLink.next = first;
        first = newLink;
    }

    public Link deleteFirst(){
        Link temp = first;
        first = first.next;
        System.out.println("Deleted  -> "+temp);
        return temp;
    }

    public Link find(Employee employee){
        Link curLink = first;
        while(null != curLink){
            curLink = curLink.next;
            if(curLink.employee.equals(employee)){
                return curLink;
            }
        }
        return null;
    }

    public void delete(Employee employee) {
        Link previous = first;
        Link curLink = first;
        while (!curLink.employee.equals(employee)) {
            previous = curLink;
            curLink = curLink.next;
            if (curLink == null) {
                System.out.println("Employee Not Found.");
                return;
            }
        }


            previous.next = curLink.next;
        }
    }
}

public class Main {

    public static void main(String[] args) {
        Employee deepak = new Employee("Deepak","Chaturvedi",1);
        Employee aditya = new Employee("Aditya","Chaturvedi",2);
        Employee t2 = new Employee("Titu","Mishra",3);
        Employee dhruv = new Employee("Dhruv","Chaturvedi",4);

        LinkedList linkedList = new LinkedList();
        linkedList.insertFirst(deepak);
        linkedList.insertFirst(aditya);
        linkedList.insertFirst(t2);
        linkedList.insertFirst(dhruv);

        linkedList.display();

        linkedList.deleteFirst();

        System.out.println(linkedList.find(deepak));

        linkedList.delete(dhruv);

        linkedList.delete(aditya);

        linkedList.display();

    }
}
