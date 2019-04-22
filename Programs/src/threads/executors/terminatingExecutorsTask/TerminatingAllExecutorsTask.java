package Programs.src.threads.executors.terminatingExecutorsTask;

import Programs.src.threads.executors.common.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TerminatingAllExecutorsTask {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("["+Thread.currentThread().getName()+"] Starting Main Thread");

        ExecutorService executorService = Executors.newCachedThreadPool(new NamedThreadsFactory());

        LoopTaskA task1 = new LoopTaskA();
        LoopTaskF task2 = new LoopTaskF();
        CalculationTaskB task3 = new CalculationTaskB(20,30,1000);
        FactorialTaskB task4 = new FactorialTaskB(30,3000);

        executorService.execute(task1);
        executorService.execute(task2);
        executorService.submit(task3);
        executorService.submit(task4);

        Thread.sleep(5000);

        executorService.shutdownNow();

        System.out.println("["+Thread.currentThread().getName()+"] All Threads terminated = "+
                executorService.awaitTermination(500, TimeUnit.MILLISECONDS));


        System.out.println("["+Thread.currentThread().getName()+"] Ending Main Thread");
    }
}
