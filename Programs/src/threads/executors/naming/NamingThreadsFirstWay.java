package Programs.src.threads.executors.naming;

import Programs.src.threads.executors.common.LoopTaskB;

public class NamingThreadsFirstWay {

    public static void main(String[] args) {
        System.out.println("#####[" +Thread.currentThread().getName() +" ] Starting ######");

        new Thread(new LoopTaskB()).start();

        Thread t = new Thread(new LoopTaskB());

        t.start();

        System.out.println("#####[" +Thread.currentThread().getName() +" ] Ending ######");
    }
}
