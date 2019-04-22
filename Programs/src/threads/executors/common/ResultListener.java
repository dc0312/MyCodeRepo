package Programs.src.threads.executors.common;

public interface ResultListener<T> {

    void notifyResult(T result);
}
