package com.dc.multithreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class InterThreadCommunication {

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<Integer>();
        Producer p = new Producer(q);
        Consumer c = new Consumer(q);
        p.start();
        c.start();
    }

}

class Producer extends Thread {

    Queue q;

    public Producer(Queue q) {
        this.q = q;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (q) {

                if (q.size() == 3) {
                    try {
                        System.out.println("Producer is waiting for Consumer to consume...");
                        q.wait();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                } else {
                    Random r = new Random();
                    int i = r.nextInt(10);
                    System.out.println("Producer produce "+i);
                    q.add(i);
                    q.notify();
                }
            }
        }
    }

}

class Consumer extends Thread {

    Queue q;

    public Consumer(Queue q) {
        this.q = q;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (q) {

                if (q.isEmpty()) {
                    try {
                        System.out.println("Consumer is waiting for Producer to produce...");
                        q.wait();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Consumer Thread is removing "+q.remove());
                    q.notify();
                }
            }
        }
    }

}
