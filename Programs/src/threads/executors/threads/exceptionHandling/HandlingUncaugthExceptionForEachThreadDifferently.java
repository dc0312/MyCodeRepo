package Programs.src.threads.executors.threads.exceptionHandling;

import Programs.src.threads.executors.common.ExceptionLeakingTask;
import Programs.src.threads.executors.common.ThreadExceptionHandler;

public class HandlingUncaugthExceptionForEachThreadDifferently {
    public static void main(String[] args) {
        System.out.println("["+Thread.currentThread().getName()+"] Starting Main Thread");

        Thread.setDefaultUncaughtExceptionHandler(new ThreadExceptionHandler("DEFAULT_HANDLER"));

        Thread t1 = new Thread(new ExceptionLeakingTask(),"MyThread-1");
        t1.setUncaughtExceptionHandler(new ThreadExceptionHandler("CUSTOM_HANDLER"));
        Thread t2 = new Thread(new ExceptionLeakingTask(),"MyThread-1");
        Thread t3 = new Thread(new ExceptionLeakingTask(),"MyThread-1");
        t3.setUncaughtExceptionHandler(new ThreadExceptionHandler("CUSTOM_HANDLER"));
        Thread t4 = new Thread(new ExceptionLeakingTask(),"MyThread-1");

        t1.start();
        t2.start();
        t3.start();
        t4.start();


        System.out.println("["+Thread.currentThread().getName()+"] Ending Main Thread");
    }
}
