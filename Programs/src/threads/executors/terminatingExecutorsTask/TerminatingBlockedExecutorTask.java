package Programs.src.threads.executors.terminatingExecutorsTask;

import Programs.src.threads.executors.common.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TerminatingBlockedExecutorTask {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("["+Thread.currentThread().getName()+"] Starting Main Thread");

        ExecutorService  service = Executors.newCachedThreadPool(new NamedThreadsFactory());

        LoopTaskA task1 = new LoopTaskA();
        LoopTaskG task2 = new LoopTaskG();
        FactorialTaskB task3 = new FactorialTaskB(30,1000);

        Future f1 = service.submit(task1);
        Future f2 = service.submit(task2);
        Future f3 = service.submit(task3);

        service.shutdown();

        Thread.sleep(3000);

        System.out.println("["+Thread.currentThread().getName()+" ] Invoking cancel()  on all task");

        f1.cancel(true);
        f2.cancel(true);
        f3.cancel(true);

        System.out.println("["+Thread.currentThread().getName()+"] Ending Main Thread");
    }
}
