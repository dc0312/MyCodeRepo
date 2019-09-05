package com.dc.multithreading;

import java.util.ArrayList;
import java.util.Iterator;

public class FailFast {
    
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> l = new ArrayList<>();
        MyThread t = new MyThread(l);
        l.add(10);
        l.add(20);
        l.add(30);
        
        t.start();
        Iterator<Integer> itr = l.iterator();
        
        while(itr.hasNext()) {
            System.out.println("Iterating over the list ");
            System.out.println(itr.next());
            Thread.sleep(1000);
        }
    }

}

class MyThread extends Thread{
    
    static ArrayList<Integer> l = new ArrayList<>();
    
    public MyThread(ArrayList<Integer> l) {
        this.l = l;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("Child Thread Updating.");
            l.add(40);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}