package com.dc.data.structures.hashtable;

public class SimpleHashTable {

    private StoredEmployee [] hashTable;

    public SimpleHashTable() {
        hashTable = new StoredEmployee[10];
    }

    public void put(String key, Employee employee){
        int hashedKey = hashedKey(key);
        if(occupied(hashedKey)){
            int stopIndex = hashedKey;
            if(hashedKey == hashTable.length-1){
                hashedKey =0;
            }else{
                hashedKey++;
            }
            while(occupied(hashedKey) && hashedKey != stopIndex){
                hashedKey = (hashedKey+1) % hashTable.length;
            }
        }
        if(hashTable[hashedKey] != null){
            System.out.println("Sorry Collision Occurred");
        }else{
            hashTable[hashedKey] = new StoredEmployee(key,employee);
        }

    }

    public Employee get(String key){
        int hashedKey = findKey(key);
        if(hashedKey == -1){
            return null;
        }
        return hashTable[hashedKey].employee;
    }
    public Employee remove(String key){
        int hashedkey = findKey(key);

        Employee employee = hashTable[hashedkey].employee;
        hashTable[hashedkey] = null;
        StoredEmployee [] oldHashTable = hashTable;
        hashTable = new StoredEmployee[oldHashTable.length];
        for(int i=0; i<hashTable.length;i++){
            if(oldHashTable[i]!=null){
                put(oldHashTable[i].key,oldHashTable[i].employee);
            }
        }
        return employee;
    }

    private int hashedKey(String key){
        return key.length() % hashTable.length;
    }

    private boolean occupied(int hashedKey){
        return null != hashTable[hashedKey];
    }

    private int findKey(String key){
        int hashedKey = hashedKey(key);
        if(null != hashTable[hashedKey] && hashTable[hashedKey].key.equals(key)){
            return hashedKey;
        }

        int stopindex = hashedKey;

        if(hashedKey == hashTable.length-1){
            hashedKey =0;
        }else{
            hashedKey++;
        }
        while(hashedKey != stopindex && null != hashTable[hashedKey] && !hashTable[hashedKey].key.equals(key)){
            hashedKey = (hashedKey +1) % hashTable.length;
        }
        if(null != hashTable[hashedKey] && hashTable[hashedKey].key.equals(key)){
            return hashedKey;
        }else{
            return -1;
        }
    }

    public void display(){
        for(int i =0; i<hashTable.length;i++){
            if(hashTable[i]==null){
                System.out.println("Empty");
            }else{
                System.out.println("Position " + i +" -> "+hashTable[i]);
            }

        }
    }
}
