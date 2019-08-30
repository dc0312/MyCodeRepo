package com.dc.data.structures.hashtable;

public class Main {

    public static void main(String[] args) {
        Employee janeJones = new Employee("Jane","Jones",11);
        Employee johndoe = new Employee("John","Doe",12);
        Employee marySmith = new Employee("Mary","Smith",13);
        Employee mikeWilson = new Employee("Mike","Wilson",14);
        Employee billend = new Employee("Bill","End",15);

        ChainedHashTable hashTable = new ChainedHashTable();

        hashTable.put("Jones",janeJones);
        hashTable.put("Doe",johndoe);
        hashTable.put("Wilson",mikeWilson);
        hashTable.put("Smith",marySmith);

        hashTable.remove("Jones");
        hashTable.remove("Wilson");

        hashTable.display();

        System.out.println("Retrieve " +hashTable.get("Smith"));
    }
}
