package Programs.src.threads.executors.common;

public class ExceptionLeakingTask implements Runnable {

    @Override
    public void run() {
        throw new RuntimeException();
    }
}
