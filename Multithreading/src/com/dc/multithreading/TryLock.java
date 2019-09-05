package com.dc.multithreading;

import java.util.concurrent.locks.ReentrantLock;

public class TryLock {
    
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread t1 = new Thread(new IncrementingThread(counter),"Incrementing Thread");
        Thread t2 = new Thread(new DecrementingThread(counter),"Decrementing Thread");
        
        t1.start();
        t2.start();
        
        t1.join();
        t2.join();
        
        System.out.println(counter.value());
    }

}

class Counter{
    int count =0;
    
    Lock lock = new Lock();
    
    public void increment() throws InterruptedException {
            for(int i=0;i<1000;i++) {
                lock.lock();
                count++;
                lock.unlock();
            }
    }
    
    public void decrement() throws InterruptedException {
            for(int i =0; i<1000;i++) {
                lock.lock();
                count--;
                lock.unlock();
            }
    }
    
    public int value() {
        return count;
    }
}

class IncrementingThread implements Runnable{
    
    public Counter counter;
    
    public IncrementingThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        try {
            counter.increment();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}

class DecrementingThread implements Runnable{
    
    public Counter counter;
    
    public DecrementingThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
       try {
        counter.decrement();
    } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    }
    
}

class Lock{

    private boolean isLocked = false;

    public synchronized void lock()
    throws InterruptedException{
      System.out.println("Thread running "+Thread.currentThread().getName());  
      while(isLocked){
          System.out.println("Thread waiting "+Thread.currentThread().getName());
        wait();
      }
      isLocked = true;
    }

    public synchronized void unlock(){
        System.out.println("Thread notifying "+Thread.currentThread().getName());
      isLocked = false;
      notify();
    }
  }
