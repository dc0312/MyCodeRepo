package Programs.src.threads.executors.threadsJoining;

import Programs.src.threads.executors.common.LoopTaskC;

public class JoiningThreads {

    public static void main(String[] args) throws InterruptedException {
        String currentThread = Thread.currentThread().getName();
        System.out.println("#####[" +Thread.currentThread().getName() +" ] Starting ######");

        Thread t1 = new Thread(new LoopTaskC(),"MyThread-1");
        Thread t2 = new Thread(new LoopTaskC(),"MyThread-2");
        Thread t3 = new Thread(new LoopTaskC(),"MyThread-3");
        Thread t4 = new Thread(new LoopTaskC(),"MyThread-4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        System.out.println("["+currentThread+"] "+currentThread + " joined "+
                t1.getName());

        t2.join();
        System.out.println("["+currentThread+"] "+currentThread + " joined "+
                                   t2.getName());

        t3.join();
        System.out.println("["+currentThread+"] "+currentThread + " joined "+
                                   t3.getName());

        t4.join();
        System.out.println("["+currentThread+"] "+currentThread + " joined "+
                                   t4.getName());


        System.out.println("#####[" +currentThread +" ] Ending ######");

    }
}
