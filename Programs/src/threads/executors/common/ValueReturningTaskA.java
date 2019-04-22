package Programs.src.threads.executors.common;

import java.util.concurrent.TimeUnit;

public class ValueReturningTaskA implements Runnable{

    private static int id =0;
    private String taskId;

    private int a;
    private int b;
    private long sleepTime;

    private int sum;

    private boolean done = false;

    public ValueReturningTaskA(int a, int b, long sleepTime){
        this.a =a;
        this.b =b;
        this.sleepTime = sleepTime;

        this.id = ++id;
        this.taskId = "ValueReturnTaskA" + id;
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

        done = true;

        synchronized (this){
            System.out.println("["+currentThread+"]<"+taskId+"....Notifying###");
            notifyAll();
        }

    }

    public  int getSum(){
        if(!done){
            synchronized (this){
                try {
                    System.out.println("["+Thread.currentThread().getName()+"] ....Waiting for the result from "+taskId+"###");
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("["+Thread.currentThread().getName()+"]....WOKEN UP for task id "+taskId+"###");
        return sum;
    }
}
