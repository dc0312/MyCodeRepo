package Programs.src.threads.executors.terminatingThreads;

import Programs.src.threads.executors.common.LoopTaskD;
import Programs.src.threads.executors.common.ValueReturningTaskA;

public class TerminatingThreadsFirstWay {

    public static void main(String[] args) {

        System.out.println("["+Thread.currentThread().getName()+"] Starting Main Thread");

        LoopTaskD task1 = new LoopTaskD();
        LoopTaskD task2 = new LoopTaskD();
        LoopTaskD task3 = new LoopTaskD();


        new Thread(task1,"MyThread-1").start();
        new Thread(task2,"MyThread-2").start();
        new Thread(task3,"MyThread-3").start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        task1.cancel();
        task2.cancel();
        task3.cancel();

        System.out.println("["+Thread.currentThread().getName()+"] Ending Main Thread");
    }
}
