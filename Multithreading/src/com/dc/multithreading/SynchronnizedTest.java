package com.dc.multithreading;

class MyThread1 implements Runnable{

    Test test;

    public MyThread1(Test test) {
        this.test = test;
    }

    @Override
    public void run() {
        System.out.println("Thead  running : "+Thread.currentThread().getName());
        try {
            test.test();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread2 implements Runnable{

    Test test;

    public MyThread2(Test test) {
        this.test = test;
    }

    @Override
    public void run() {
        System.out.println("Thead  running : "+Thread.currentThread().getName());
        try {
            test.test();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class SynchronnizedTest {

    public static void main(String[] args) {
        Test test = new Test();
        Thread myThread1 = new Thread(new MyThread1(test));
        myThread1.setName("thread 1");
        Thread myThread2 = new Thread(new MyThread2(test));
        myThread2.setName("thread 2");

        myThread1.start();
        myThread2.start();

    }
}

class Test{

    public  void test() throws InterruptedException {
        System.out.println("Thread entering the synch block." + Thread.currentThread().getName());

        synchronized(this){
            System.out.println(Thread.currentThread().getName() +" Inside Synch Block");
            Thread.sleep(10000);
        }

        System.out.println("Outside Synch block"+Thread.currentThread().getName());
    }
}
