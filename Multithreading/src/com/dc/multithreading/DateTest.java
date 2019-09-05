package com.dc.multithreading;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ForkJoinPool;

public class DateTest {
    
    public static void main(String[] args) {
       CopyOnWriteArrayList<Integer> l = new CopyOnWriteArrayList<>();
       l.add(10);
       l.add(20);
       l.add(30);
       l.add(40);
       
       Iterator<Integer> itr = l.iterator();
       
       while(itr.hasNext()) {
           System.out.println(itr.next());
           l.add(50);
       }
       
       int x  =2;
       int y = 4;
       x+=y;
       System.out.println(x);
    }

}
