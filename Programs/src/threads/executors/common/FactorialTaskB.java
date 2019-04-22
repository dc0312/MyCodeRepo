package Programs.src.threads.executors.common;

import java.util.concurrent.Callable;

public class FactorialTaskB implements Callable {

    private static int count=0;
    private int id;
    private String taskId;

    private int a;
    private long sleepTime;

    private long factorial;

    @Override
    public Long call() {
        String currentThreadName = Thread.currentThread().getName();
        System.out.println("#####[" +currentThreadName +"] < "+taskId +"> Starting ######");
        factorial = 1L;
        for (int i =1;i<a; i++) {
            factorial *=i;
            System.out.println("["+ currentThreadName+"]< "+taskId+" >Intermediate Factorial of "+i+" is "+ factorial);

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("["+Thread.currentThread().getName()+"] < "+taskId+ " Interrupted ...Cancelling it.");
                break;
            }

        }


        System.out.println("#####[" +currentThreadName +"] < "+taskId +"> Ending ######");
        return factorial;
    }

    public FactorialTaskB(int a, long sleepTime){
        this.a = a;
        this.sleepTime = sleepTime;
        this.id = ++count;
        this.taskId = "FactorialTaskB -"+id;
    }
}
