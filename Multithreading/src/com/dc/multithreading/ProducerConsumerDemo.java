package com.dc.multithreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

class ProducerNew implements Runnable{
    ReentrantLock l;
    Queue<Integer> q;

    public ProducerNew(ReentrantLock l, Queue<Integer> q) {
        this.l = l;
        this.q = q;
    }
    @Override
    public void run() {
        while(true){
            l.lock();
            while(q.size()!=3){
                Random r = new Random();
                int i = r.nextInt();
                q.add(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Adding :"+i);
            }
            l.unlock();
        }
    }
}

class ConsumerNew implements Runnable{
    ReentrantLock l;
    Queue<Integer> q;

    public ConsumerNew(ReentrantLock l, Queue<Integer> q) {
        this.l = l;
        this.q = q;
    }
    @Override
    public void run() {
        while(true){
            l.lock();
            while(!q.isEmpty()){
                System.out.println("Removing :"+q.remove());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            l.unlock();
        }
    }
}
public class ProducerConsumerDemo {

    public static void main(String[] args) {
        ReentrantLock l = new ReentrantLock();
        Queue<Integer> q = new LinkedList<>();

        Thread t1 = new Thread(new ProducerNew(l,q));
        Thread t2 = new Thread(new ConsumerNew(l,q));

        t1.start();
        t2.start();
    }
}
