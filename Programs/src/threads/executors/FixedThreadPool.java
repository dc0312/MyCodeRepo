package Programs.src.threads.executors;

import Programs.src.threads.executors.common.LoopTaskA;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPool {

    public static void main(String[] args) {
        System.out.println("Main Thread Started.");

        ExecutorService service = Executors.newFixedThreadPool(3);

        service.execute(new LoopTaskA());
        service.execute(new LoopTaskA());
        service.execute(new LoopTaskA());
        service.execute(new LoopTaskA());
        service.execute(new LoopTaskA());
        service.execute(new LoopTaskA());

        service.shutdown();

        service.submit(new LoopTaskA());

        System.out.println("Main Thread Ended.");
    }
}
