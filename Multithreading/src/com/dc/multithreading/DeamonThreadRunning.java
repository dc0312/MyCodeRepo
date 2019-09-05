package com.dc.multithreading;

public class DeamonThreadRunning {
    
    public static void main(String[] args) {
        
        System.out.println("Main Thread Started");
        Thread t1 = new Thread(() ->{
            while(true) {
                System.out.println("Daemon thread Running...");
            }
        });
        t1.setDaemon(true);
        t1.start();
        System.out.println("Main Thread Ended");
    }

}
