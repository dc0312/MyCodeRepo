package Programs.src.threads.executors.threadsJoining;

import Programs.src.threads.executors.common.SumObserver;
import Programs.src.threads.executors.common.ValueReturningTaskC;

public class ReturnValueThirdWay {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("["+Thread.currentThread().getName()+"] Starting Main Thread");

        ValueReturningTaskC task1 = new ValueReturningTaskC(2,3,2000);
        Thread t1 = new Thread(task1,"Thread-1");

        ValueReturningTaskC task2 = new ValueReturningTaskC(8 ,10,500);
        Thread t2 = new Thread(task2,"Thread-2");

        ValueReturningTaskC task3 = new ValueReturningTaskC(32,10,1000);
        Thread t3 = new Thread(task3,"Thread-3");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        System.out.println("Result 1 : "+task1.getSum());

        t2.join();
        System.out.println("Result 2 : "+task2.getSum());

        t3.join();
        System.out.println("Result 3 : "+task3.getSum());



        System.out.println("["+Thread.currentThread().getName()+"] Ending Main Thread");
    }
}
