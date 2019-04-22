package Programs.src.threads.executors.terminatingThreads;

import Programs.src.threads.executors.common.LoopTaskF;

public class TerminatingThreadsSecondWay {

    public static void main(String[] args) {

        System.out.println("["+Thread.currentThread().getName()+"] Starting Main Thread");

        LoopTaskF task1 = new LoopTaskF();
        LoopTaskF task2 = new LoopTaskF();
        LoopTaskF task3 = new LoopTaskF();

        Thread t1 = new Thread(task1, "Mythread-1");
        Thread t2 = new Thread(task2, "Mythread-2");
        Thread t3 = new Thread(task3, "Mythread-3");

        t1.start();
        t2.start();
        t3.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t1.interrupt();
        t2.interrupt();
        t3.interrupt();

        System.out.println("["+Thread.currentThread().getName()+"] Ending Main Thread");
    }
}
