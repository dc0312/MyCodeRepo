package Programs.src.threads.executors.returningValues;

import Programs.src.threads.executors.common.SumObserver;
import Programs.src.threads.executors.common.ValueReturningTaskB;

public class ReturnValueSecondWay {

    public static void main(String[] args) {

        System.out.println("["+Thread.currentThread().getName()+"] Starting Main Thread");

        ValueReturningTaskB task1 = new ValueReturningTaskB(2,3,2000,new SumObserver("task-1"));
        Thread t1 = new Thread(task1,"Thread-1");

        ValueReturningTaskB task2 = new ValueReturningTaskB(8 ,10,500,new SumObserver("task-2"));
        Thread t2 = new Thread(task2,"Thread-2");

        ValueReturningTaskB task3 = new ValueReturningTaskB(32,10,1000,new SumObserver("task-3"));
        Thread t3 = new Thread(task3,"Thread-3");

        t1.start();
        t2.start();
        t3.start();

        System.out.println("["+Thread.currentThread().getName()+"] Ending Main Thread");
    }
}
