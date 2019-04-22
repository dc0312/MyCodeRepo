package Programs.src.threads.executors;

import Programs.src.threads.executors.common.LoopTaskA;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadPool {

    public static void main(String[] args) {
        System.out.println("Main Thread Started.");

        ExecutorService service = Executors.newSingleThreadExecutor();

        service.execute(new LoopTaskA());
        service.execute(new LoopTaskA());
        service.execute(new LoopTaskA());

        service.shutdown();

        System.out.println("Main Thread Ended.");
    }
}
