package Programs.src.threads.executors.naming;

import Programs.src.threads.executors.common.LoopTaskC;
import Programs.src.threads.executors.common.NamedThreadsFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class NamingThreadsExecutorsThread2 {

    public static void main(String[] args) throws  InterruptedException{
        System.out.println("#####[" +Thread.currentThread().getName() +" ] Starting ######");

        ExecutorService service = Executors.newCachedThreadPool(new NamedThreadsFactory());

        service.execute(new LoopTaskC());
        service.execute(new LoopTaskC());
        service.execute(new LoopTaskC());

        TimeUnit.SECONDS.sleep(15);

        service.execute(new LoopTaskC());
        service.execute(new LoopTaskC());
        service.execute(new LoopTaskC());
        service.execute(new LoopTaskC());
        service.execute(new LoopTaskC());
        service.execute(new LoopTaskC());

        service.shutdown();

        System.out.println("#####[" +Thread.currentThread().getName() +" ] Ending ######");
    }
}
