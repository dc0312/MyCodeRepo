package Programs.src.threads.executors.terminatingExecutorsTask;

import Programs.src.threads.executors.common.FactorialTaskA;
import Programs.src.threads.executors.common.LoopTaskD;
import Programs.src.threads.executors.common.NamedThreadsFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TerminatingExecutorsTaskFirstWay {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("["+Thread.currentThread().getName()+"] Starting Main Thread");

        ExecutorService  service = Executors.newCachedThreadPool(new NamedThreadsFactory());

        LoopTaskD task1 = new LoopTaskD();
        FactorialTaskA task2 = new FactorialTaskA(30,1000);

        service.execute(task1);
        service.submit(task2);

        Thread.sleep(3000);

        task1.cancel();
        task2.cancel();

        service.shutdown();

        /*task1.cancel();
        task2.cancel();*/


        System.out.println("["+Thread.currentThread().getName()+"] Ending Main Thread");
    }
}
