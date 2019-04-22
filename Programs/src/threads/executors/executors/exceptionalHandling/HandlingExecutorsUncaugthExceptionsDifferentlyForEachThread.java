package Programs.src.threads.executors.executors.exceptionalHandling;

import Programs.src.threads.executors.common.ExceptionLeakingTask;
import Programs.src.threads.executors.common.ThreadExceptionHandler;
import Programs.src.threads.executors.common.ThreadsFactoryExceptionHandler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HandlingExecutorsUncaugthExceptionsDifferentlyForEachThread {
    public static void main(String[] args) {
        System.out.println("[" + Thread.currentThread().getName() + "] Starting Main Thread");

        Thread.setDefaultUncaughtExceptionHandler(new ThreadExceptionHandler());

        ExecutorService executorService = Executors.newCachedThreadPool(new ThreadsFactoryExceptionHandler());

        executorService.execute(new ExceptionLeakingTask());
        executorService.execute(new ExceptionLeakingTask());
        executorService.execute(new ExceptionLeakingTask());

        ExecutorService executorService1 = Executors.newCachedThreadPool(new ThreadsFactoryExceptionHandler());

        executorService1.execute(new ExceptionLeakingTask());
        executorService1.execute(new ExceptionLeakingTask());
        executorService1.execute(new ExceptionLeakingTask());

        executorService.shutdown();
        executorService1.shutdown();



        System.out.println("[" + Thread.currentThread().getName() + "] Ending Main Thread");
    }
}