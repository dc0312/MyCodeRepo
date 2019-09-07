package com.dc.multithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class Passenger extends Thread{
    CyclicBarrier cyclicBarrier;
    private int duration;

    Passenger(int duration, CyclicBarrier cyclicBarrier, String name){
        super(name);
        this.duration = duration;
        this.cyclicBarrier= cyclicBarrier;

    }

    @Override
    public void run() {
        try {
            Thread.sleep(duration);
            System.out.println(Thread.currentThread().getName() + " arrived.");
            int await = cyclicBarrier.await();
            if(await ==0){
                System.out.println("Four Passenger Arrived.");
            }
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}

public class CyclicBarrierDemo {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4);
        Passenger p1 = new Passenger(1000,cyclicBarrier,"DC");
        Passenger p2 = new Passenger(3000,cyclicBarrier,"AC");
        Passenger p3 = new Passenger(6000,cyclicBarrier,"LC");
        Passenger p4 = new Passenger(9000,cyclicBarrier,"T2");

        Passenger p5 = new Passenger(1000,cyclicBarrier,"Nikku");
        Passenger p6 = new Passenger(2000,cyclicBarrier,"Ram");
        Passenger p7 = new Passenger(3000,cyclicBarrier,"Babu");
        Passenger p8 = new Passenger(4000,cyclicBarrier,"Kannu");

        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();
        p6.start();
        p7.start();
        p8.start();


    }
}
