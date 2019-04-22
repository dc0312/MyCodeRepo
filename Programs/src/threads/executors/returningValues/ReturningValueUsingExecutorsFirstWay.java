package Programs.src.threads.executors.returningValues;

import Programs.src.threads.executors.common.CalculationTaskA;
import Programs.src.threads.executors.common.LoopTaskA;
import Programs.src.threads.executors.common.NamedThreadsFactory;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ReturningValueUsingExecutorsFirstWay {

    public static void main(String[] args) {
        String currentThread = Thread.currentThread().getName();

        System.out.println("["+currentThread+"] Starting Main Thread");

        ExecutorService service = Executors.newCachedThreadPool(new NamedThreadsFactory());

        Future result1 = service.submit(new CalculationTaskA(50,20,1000));
        Future result2 = service.submit(new CalculationTaskA(10,40,500));
        Future result3 = service.submit(new CalculationTaskA(25,20,300));

        Future result4 = service.submit(new LoopTaskA());
        Future result5 = service.submit(new LoopTaskA(), 99.8);

        try {
            System.out.println("Result 1 = "+result1.get());
            System.out.println("Result 2 = "+result2.get());
            System.out.println("Result 3 = "+result3.get());
            System.out.println("Result 4 = "+result4.get());
            System.out.println("Result 5 = "+result5.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        service.shutdown();
        System.out.println("["+currentThread+"] Ending Main Thread");
    }
}
