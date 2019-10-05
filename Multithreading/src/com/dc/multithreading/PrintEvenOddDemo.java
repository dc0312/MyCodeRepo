package com.dc.multithreading;

import java.util.concurrent.atomic.AtomicInteger;

class PrintEven implements Runnable{
    Object lock;
    AtomicInteger i;
    public PrintEven(AtomicInteger i, Object lock) {
        this.lock = lock;
        this.i =i;
    }

    @Override
    public void run() {
        while(i.get()<=10){
            synchronized (lock){
                if(i.get()%2==0){
                    System.out.println(Thread.currentThread().getName()+" : "+i);
                    i.getAndIncrement();
                    lock.notifyAll();
                }else{
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }


        }
    }
}

class PrintOdd implements Runnable{
    Object lock;
    AtomicInteger i;
    public PrintOdd(AtomicInteger i, Object lock) {
        this.lock = lock;
        this.i =i;
    }
    @Override
    public void run() {
        while(i.get()<=10){
            synchronized (lock){
                if(i.get()%2==1){
                    System.out.println(Thread.currentThread().getName()+" : "+i);
                    i.getAndIncrement();
                    lock.notifyAll();
                } else{
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }


        }
    }
}
public class PrintEvenOddDemo {

    public static void main(String[] args) {
        Object lock = new Object();
        AtomicInteger i = new AtomicInteger(1);
        Thread t1 = new Thread(new PrintEven(i,lock),"Print Even");
        Thread t2 = new Thread(new PrintOdd(i,lock),"Print Odd");

        t1.start();
        t2.start();
    }
}
