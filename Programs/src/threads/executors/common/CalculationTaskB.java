package Programs.src.threads.executors.common;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class CalculationTaskB implements Callable {

    private static int id =0;
    private String taskId;

    private int a;
    private int b;
    private long sleepTime;

    private int sum;

    public CalculationTaskB(int a, int b, long sleepTime){
        this.a =a;
        this.b =b;
        this.sleepTime = sleepTime;

        this.id = ++id;
        this.taskId = "CalculationTaskB" + id;
    }

    @Override
    public TaskResult<String,Integer> call() throws Exception{
        String currentThread = Thread.currentThread().getName();

        System.out.println("##### ["+currentThread +"] <"+taskId+ "> STARTING#####");
        System.out.println("##### ["+currentThread +"] <"+taskId+ ">Sleeping for "+ sleepTime+" milliseconds#####");

        TimeUnit.MILLISECONDS.sleep(sleepTime);

        sum = a+b;

        System.out.println("##### ["+currentThread +"] <"+taskId+ "> ENDING#####");

        return new TaskResult<>(taskId,sum);

    }

}
