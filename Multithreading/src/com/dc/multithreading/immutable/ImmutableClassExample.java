package com.dc.multithreading.immutable;

import java.util.HashMap;
import java.util.Iterator;

public final class ImmutableClassExample {
    
    private final int id;
    private final String name;
    private final HashMap<String , String> testMap;
    
    public ImmutableClassExample(int id, String name, HashMap<String, String> hm) {
        this.id = id;
        this.name = name;
        HashMap<String, String> tempMap = new HashMap<>();
        String key;
        Iterator<String> it = hm.keySet().iterator();
        while(it.hasNext()) {
            key = it.next();
            tempMap.put(key, hm.get(key));
        }
        testMap=tempMap;
        //this.testMap = hm;
    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @return the testMap
     */
    public HashMap<String, String> getTestMap() {
        return (HashMap<String, String>) testMap.clone();
    }
    
    public static void main(String[] args) {
        HashMap<String, String> h1 = new HashMap<>();
        h1.put("1" , "first");
        h1.put("2" , "second");
        
        int i = 10;
        String s = "original";
        
        ImmutableClassExample classExample = new ImmutableClassExample(i, s, h1);
        
        System.out.println(classExample.getId());
        System.out.println(classExample.getName());
        System.out.println(classExample.getTestMap());
        
       
        i =20;
        s = "modified";
        h1.put("3" , "third");
        
        System.out.println(classExample.getId());
        System.out.println(classExample.getName());
        System.out.println(classExample.getTestMap());
        
        HashMap<String, String> hm = classExample.getTestMap();
        hm.put("4", "fourth");
        
        System.out.println(classExample.getTestMap());
        
    }

}
