package Programs.src.threads.executors.common;

import java.util.concurrent.TimeUnit;

public class ValueReturningTaskB implements Runnable{

    private static int id =0;
    private String taskId;

    private int a;
    private int b;
    private long sleepTime;

    private int sum;

    private ResultListener<Integer> listener;

    public ValueReturningTaskB(int a, int b, long sleepTime,ResultListener listener){
        this.a =a;
        this.b =b;
        this.sleepTime = sleepTime;
        this.listener = listener;

        this.id = ++id;
        this.taskId = "ValueReturnTaskB" + id;
    }

    @Override
    public void run() {
        String currentThread = Thread.currentThread().getName();

        System.out.println("##### ["+currentThread +"] <"+taskId+ "> STARTING#####");
        System.out.println("##### ["+currentThread +"] <"+taskId+ ">Sleeping for "+ sleepTime+" milliseconds#####");

        try {
            TimeUnit.MILLISECONDS.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        sum = a+b;

        System.out.println("##### ["+currentThread +"] <"+taskId+ "> ENDING#####");

        listener.notifyResult(sum);

    }

}
