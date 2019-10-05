package com.dc.multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

class EvenQueue implements Runnable{
    BlockingQueue<Integer> q;
    AtomicInteger i;

    public EvenQueue(BlockingQueue<Integer> q, AtomicInteger i) {
        this.q = q;
        this.i = i;
    }

    @Override
    public void run() {
        while (i.get()<=10){
            q.add(i.getAndIncrement());
        }
    }
}

class OddQueue implements Runnable{
    BlockingQueue<Integer> q;

    public OddQueue(BlockingQueue<Integer> q) {
        this.q = q;
    }

    @Override
    public void run() {
        while (!q.isEmpty()){
            try {
                System.out.println(q.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class PrintEvenOddUsingBlockingQueue {

    public static void main(String[] args) {
        BlockingQueue<Integer> q = new ArrayBlockingQueue<Integer>(10);
        AtomicInteger i = new AtomicInteger(1);
        Thread t1 = new Thread(new EvenQueue(q,i));
        Thread t2 = new Thread(new OddQueue(q));

        t1.start();
        t2.start();
    }
}
