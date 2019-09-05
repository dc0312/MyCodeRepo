package com.dc.multithreading;

public class DeadLock {
    
    Resource r1 = new Resource();
    Resource r2 = new Resource();
    
    public void method1() {
        synchronized (r1) {
            System.out.println("R1 is locked");
            synchronized (r2) {
                System.out.println("R2 is locked");
            }
        }
    }
    
    public void method2() {
        synchronized (r2) {
            System.out.println("R2 is locked");
            synchronized (r1) {
                System.out.println("R1 is locked.");
            }
        }
    }
    
    public static void main(String[] args) {
        DeadLock d = new DeadLock();
        Thread t1 = new Thread(new Task1(d));
        Thread t2 = new Thread(new Task2(d));
        
        t1.start();
        t2.start();
    }
    
            
}

class Task1 implements Runnable{
    DeadLock d;
    public Task1(DeadLock d) {
        this.d = d;
    }
    @Override
    public void run() {
        d.method1();
    }
    
}

class Task2 implements Runnable{
    DeadLock d;
    public Task2(DeadLock d) {
        this.d = d;
    }
    @Override
    public void run() {
        d.method2();
    }
    
}


class Resource{}
