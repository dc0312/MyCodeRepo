package com.dc.data.structures.hashtable;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class ChainedHashTable {

    public LinkedList<StoredEmployee> [] hashTable;

    ChainedHashTable(){
        hashTable = new LinkedList[10];
        for(int i =0;i <hashTable.length;i++){
            hashTable[i] = new LinkedList<StoredEmployee>();
        }
    }

    public void put(String key, Employee employee){
        int hashedKey = hashedKey(key);
        hashTable[hashedKey].add(new StoredEmployee(key,employee));
    }

    public Employee get(String key){
        int hashedKey = hashedKey(key);
        ListIterator<StoredEmployee> iterator = hashTable[hashedKey].listIterator();
        StoredEmployee employee = null;
        while(iterator.hasNext()){
            employee = iterator.next();
            if(employee.key.equals(key)){
                return employee.employee;
            }
        }
        return null;
    }

    public Employee remove(String key){
        int hashedKey = hashedKey(key);
        ListIterator<StoredEmployee> listIterator = hashTable[hashedKey].listIterator();
        StoredEmployee employee = null;
        int index = -1;
        while(listIterator.hasNext()){
            employee = listIterator.next();
            index++;
            if(employee.key.equals(key)){
                break;
            }
        }
        if(employee == null && !employee.key.equals(key)){
            return null;
        }else {
            hashTable[hashedKey].remove(index);
            return employee.employee;
        }
    }

    private int hashedKey(String key){
        return key.length() % hashTable.length;
    }

    public void display(){
        for(int i =0;i<hashTable.length;i++){
            if(hashTable[i].isEmpty()){
                System.out.println("Position "+ i + " : Empty");
            }else{
                System.out.print("Position "+i+" : " );
                ListIterator<StoredEmployee> listIterator = hashTable[i].listIterator();
                while(listIterator.hasNext()){
                    System.out.print(listIterator.next().employee);
                    System.out.print("->");
                }
                System.out.println();
            }
        }
    }
}
