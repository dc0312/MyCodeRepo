package Programs.src.threads.executors.common;

import java.util.concurrent.Callable;

public class FactorialTaskA implements Callable {

    private static int count=0;
    private int id;
    private String taskId;

    private volatile boolean shutdown = false;

    private int a;
    private long sleepTime;

    private long factorial;

    @Override
    public Long call() throws  Exception{
        String currentThreadName = Thread.currentThread().getName();
        System.out.println("#####[" +currentThreadName +"] < "+taskId +"> Starting ######");
        factorial = 1L;
        for (int i =1;i<a; i++) {
            factorial *=i;
            System.out.println("["+ currentThreadName+"]< "+taskId+" >Intermediate Factorial of "+i+" is "+ factorial);
            Thread.sleep(3000);

            synchronized (this){
                if(shutdown){
                    break;
                }
            }
        }


        System.out.println("#####[" +currentThreadName +"] < "+taskId +"> Ending ######");
        return factorial;
    }

    public void cancel(){
        System.out.println("["+Thread.currentThread().getName()+"] <"+taskId+" Cancelling it !!!");
        synchronized (this){
            this.shutdown = true;
        }
    }

    public FactorialTaskA(int a, long sleepTime){
        this.a = a;
        this.sleepTime = sleepTime;
        this.id = ++count;
        this.taskId = "FactorialTaskA -"+id;
    }

    public static class JoiningExecutorThreads {

        public static void main(String[] args) throws InterruptedException {
            String currentThread = Thread.currentThread().getName();
            System.out.println("#####[" +Thread.currentThread().getName() +" ] Starting ######");

            Thread t1 = new Thread(new LoopTaskC(),"MyThread-1");
            Thread t2 = new Thread(new LoopTaskC(),"MyThread-2");
            Thread t3 = new Thread(new LoopTaskC(),"MyThread-3");
            Thread t4 = new Thread(new LoopTaskC(),"MyThread-4");

            t1.start();
            t2.start();
            t3.start();
            t4.start();

            t1.join();
            System.out.println("["+currentThread+"] "+currentThread + " joined "+
                    t1.getName());

            t2.join();
            System.out.println("["+currentThread+"] "+currentThread + " joined "+
                                       t2.getName());

            t3.join();
            System.out.println("["+currentThread+"] "+currentThread + " joined "+
                                       t3.getName());

            t4.join();
            System.out.println("["+currentThread+"] "+currentThread + " joined "+
                                       t4.getName());


            System.out.println("#####[" +currentThread +" ] Ending ######");

        }
    }
}
