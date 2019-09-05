package com.dc.multithreading;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class COWAL {
    
    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> l = new CopyOnWriteArrayList<>();
        l.add(10);
        l.add(20);
        l.add(30);
        l.add(40);
        
        Iterator<Integer> itr = l.iterator();
        l.add(50);
        
        while(itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

}
