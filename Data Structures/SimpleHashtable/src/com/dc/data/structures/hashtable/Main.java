package com.dc.data.structures.hashtable;

public class Main {

    public static void main(String[] args) {
       /* Employee dc = new Employee("Deepak","Chaturvedi",12);
        Employee t2 = new Employee("Atul","Mishra",13);
        Employee ram = new Employee("Ram","Pandey",14);
        Employee babu = new Employee("Babu","Pandeyss",14);*/
       Employee janeJones = new Employee("Jane","Jones",11);
       Employee johndoe = new Employee("John","Doe",12);
       Employee marySmith = new Employee("Mary","Smith",13);
       Employee mikeWilson = new Employee("Mike","Wilson",14);
       Employee billend = new Employee("Bill","End",15);

        SimpleHashTable hashTable = new SimpleHashTable();
        /*hashTable.put("Chaturvedi",dc);
        hashTable.put("Mishra",t2);
        hashTable.put("Pandey",ram);
        hashTable.put("Pandeyss",babu);*/
        hashTable.put("Jones",janeJones);
        hashTable.put("Doe",johndoe);
        hashTable.put("Wilson",mikeWilson);
        hashTable.put("Smith",marySmith);



        hashTable.remove("Jones");
        hashTable.remove("Wilson");

        hashTable.display();

        System.out.println("Retrieve " +hashTable.get("Smith"));

        //System.out.println("Retrieve Pandey "+hashTable.get("Pandey"));

        /*System.out.println("Deleting "+hashTable.remove("Pandey"));
        System.out.println("Deleting "+hashTable.remove("Mishra"));
        //hashTable.display();

        System.out.println("Retrieve Pandeyss "+hashTable.get("Pandeyss"));*/
    }
}
