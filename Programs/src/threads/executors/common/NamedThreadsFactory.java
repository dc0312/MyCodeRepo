package Programs.src.threads.executors.common;

import java.util.concurrent.ThreadFactory;

public class NamedThreadsFactory implements ThreadFactory {

    public static int id=0 ;


    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r,"MyThread : "+ ++id);
        return t;
    }
}
