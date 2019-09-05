package com.diner.philosopher.multithreading;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Philosopher implements Runnable{
    
    private int id;
    private Chopstick leftChopstick;
    private Chopstick rightChopstick;
    private Random random;
    //to check how many times the philosopher has eaten.
    private AtomicInteger eatingCounter = new AtomicInteger();
    public volatile boolean isFull = false;
    /**
     * @param id
     * @param leftChopstick
     * @param rightChopstick
     * @param eatingCounter
     */
    public Philosopher(int id, Chopstick leftChopstick, Chopstick rightChopstick) {
        this.id = id;
        this.leftChopstick = leftChopstick;
        this.rightChopstick = rightChopstick;
        random = new Random();
    }
    @Override
    public void run() {
        while(!isFull) {
            try {
                think();
                if(leftChopstick.pickUp(this, State.LEFT)) {
                    if(rightChopstick.pickUp(this, State.RIGHT)) {
                        eat();
                        rightChopstick.putDown(this, State.RIGHT);
                    }
                    leftChopstick.putDown(this, State.LEFT);
                }
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    
    private void think() throws InterruptedException {
        System.out.println(this+" is thinking ...");
        Thread.sleep(random.nextInt(1000));
    }
    
    private void eat() throws InterruptedException {
        System.out.println(this+" is eating ...");
        eatingCounter.incrementAndGet();
        Thread.sleep(random.nextInt(1000));
    }

    public void setIsFull(boolean isFull) {
        this.isFull = isFull;
    }
    
    @Override
    public String toString() {
        return "Phiosopher "+id;
    }
    /**
     * @return the eatingCounter
     */
    public AtomicInteger getEatingCounter() {
        return eatingCounter;
    }
    
    
    

}
