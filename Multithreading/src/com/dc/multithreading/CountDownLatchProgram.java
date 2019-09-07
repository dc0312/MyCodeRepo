package com.dc.multithreading;

import java.util.concurrent.CountDownLatch;

class DevTeam extends Thread{
    CountDownLatch countDownLatch;

    DevTeam(CountDownLatch countDownLatch, String name){
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() +" working on dev task.");


        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countDownLatch.countDown();
    }
}

class QATeam  extends Thread{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() +" working on QA task.");
    }
}
public class CountDownLatchProgram {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);

        DevTeam devTeam1 = new DevTeam(countDownLatch,"Dev-1");
        DevTeam devTeam2 = new DevTeam(countDownLatch,"Dev-2");

        devTeam1.start();
        devTeam2.start();

        countDownLatch.await();;

        QATeam qaTeam = new QATeam();
        qaTeam.start();

    }
}
