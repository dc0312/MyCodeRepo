package Programs.src.threads.executors.naming;

import Programs.src.threads.executors.common.LoopTaskC;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NamingThreadsExecutorsThread {

    public static void main(String[] args) {
        System.out.println("#####[" +Thread.currentThread().getName() +" ] Starting ######");

        ExecutorService service = Executors.newFixedThreadPool(2);

        service.execute(new LoopTaskC());
        service.execute(new LoopTaskC());
        service.shutdown();
        ExecutorService service2 = Executors.newFixedThreadPool(2);

        service2.execute(new LoopTaskC());
        service2.execute(new LoopTaskC());
        service2.shutdown();
        System.out.println("#####[" +Thread.currentThread().getName() +" ] Ending ######");
    }
}
