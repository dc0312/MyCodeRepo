package Programs.src.threads.executors.common;

import java.util.concurrent.ThreadFactory;

public class ThreadsFactoryExceptionHandler implements ThreadFactory {

    public static int id=0 ;


    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r,"MyThread : "+ ++id);
        t.setUncaughtExceptionHandler(new ThreadExceptionHandler());
        return t;
    }
}
