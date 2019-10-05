package com.dc.multithreading;

import java.util.LinkedList;
import java.util.Queue;

public class InterthreadCommunication2 {

    static Processor processor = new Processor();

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                processor.produce();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }).start();
        
        
        new Thread(() -> {
            try {
                processor.consume();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }).start();

    }
}

class Processor {

    private int value = 0;
    private final int LIMIT = 3;
    private final int BOTTOM = 0;

    Queue<Integer> q = new LinkedList<>();

    private final Object lock = new Object();

    public void produce() throws InterruptedException {
        synchronized (lock) {
            while (true) {
                if (q.size() == LIMIT) {
                    System.out.println("Producer waiting for the consumer to consume.");
                    lock.wait();
                } else {
                    System.out.println("Adding Value " + value);
                    q.add(value++);
                    lock.notify();
                }
                Thread.sleep(500);
            }
            
        }
    }

    public void consume() throws InterruptedException {
        synchronized (lock) {
            while (true) {
                if (q.size() == BOTTOM) {
                    System.out.println("Consumer waiting for the Producer to produce.");
                    lock.wait();
                } else {
                    System.out.println("Removing Value " + q.remove());
                    lock.notify();
                }
                Thread.sleep(500);
            }
        }
    }
}
