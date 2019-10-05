package com.dc.multithreading;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

class PrintEvenLock implements Runnable{
    ReentrantLock l;
    public AtomicInteger i;

    public PrintEvenLock(ReentrantLock l, AtomicInteger i) {
        this.l = l;
        this.i = i;
    }

    @Override
    public void run() {

        while(i.get()<10){
            l.lock();
            if(i.get()%2==0){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+" : "+i.get());
                i.getAndIncrement();
            }
            l.unlock();
        }
    }
}

class PrintOddLock implements Runnable{
    ReentrantLock l;
    public AtomicInteger i;

    public PrintOddLock(ReentrantLock l, AtomicInteger i) {
        this.l = l;
        this.i = i;
    }

    @Override
    public void run() {

        while(i.get()<10){
            l.lock();
            if(i.get()%2==1){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+" : "+i.get());
                i.getAndIncrement();
            }
            l.unlock();
        }

    }
}
public class PrintOddEvenUsingLocks {
    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger(1);
        ReentrantLock l = new ReentrantLock();
        Thread t1 = new Thread(new PrintEvenLock(l,i),"Print Even");
        Thread t2 = new Thread(new PrintOddLock(l,i),"Print Odd");

        t1.start();
        t2.start();
    }
}
