package Programs.src.threads.executors.threadsJoining;

import Programs.src.threads.executors.common.LoopTaskC;
import Programs.src.threads.executors.common.LoopTaskH;
import Programs.src.threads.executors.common.NamedThreadsFactory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JoiningExecutorsThreads {

    public static void main(String[] args) throws InterruptedException {
        String currentThread = Thread.currentThread().getName();
        System.out.println("#####[" +Thread.currentThread().getName() +" ] Starting ######");

        ExecutorService executorService = Executors.newCachedThreadPool(new NamedThreadsFactory());

        CountDownLatch countDownLatch = new CountDownLatch(4);

        executorService.execute(new LoopTaskH(countDownLatch));
        executorService.execute(new LoopTaskH(countDownLatch));
        executorService.execute(new LoopTaskH(countDownLatch));
        executorService.execute(new LoopTaskH(countDownLatch));

        executorService.shutdown();

        try{
            countDownLatch.await();
            System.out.println("[" +currentThread +" ] Got the signal to continue ######");
        }catch (InterruptedException e){

        }

        System.out.println("#####[" +currentThread +" ] Ending ######");

    }
}
