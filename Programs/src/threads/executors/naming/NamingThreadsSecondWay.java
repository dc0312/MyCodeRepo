package Programs.src.threads.executors.naming;

import Programs.src.threads.executors.common.LoopTaskC;

public class NamingThreadsSecondWay {

    public static void main(String[] args) {
        System.out.println("#####[" +Thread.currentThread().getName() +" ] Starting ######");

        new Thread(new LoopTaskC(),"MyThread-1").start();

        Thread t = new Thread(new LoopTaskC());
        t.setName("MyThread-2");
        t.start();

        System.out.println("#####[" +Thread.currentThread().getName() +" ] Ending ######");
    }
}
