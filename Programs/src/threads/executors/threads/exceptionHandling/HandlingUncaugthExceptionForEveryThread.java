package Programs.src.threads.executors.threads.exceptionHandling;

import Programs.src.threads.executors.common.ExceptionLeakingTask;
import Programs.src.threads.executors.common.ThreadExceptionHandler;

public class HandlingUncaugthExceptionForEveryThread {
    public static void main(String[] args) {
        System.out.println("["+Thread.currentThread().getName()+"] Starting Main Thread");

        Thread.setDefaultUncaughtExceptionHandler(new ThreadExceptionHandler("DEFAULT_HANDLER"));

        new Thread(new ExceptionLeakingTask(), "MyThread-1").start();
        new Thread(new ExceptionLeakingTask(), "MyThread-2").start();
        new Thread(new ExceptionLeakingTask(), "MyThread-3").start();
        new Thread(new ExceptionLeakingTask(), "MyThread-4").start();

        System.out.println("["+Thread.currentThread().getName()+"] Ending Main Thread");
    }
}
