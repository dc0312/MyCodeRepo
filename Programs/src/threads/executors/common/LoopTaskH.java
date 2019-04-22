package Programs.src.threads.executors.common;

import java.util.concurrent.CountDownLatch;

public class LoopTaskH implements Runnable{

    private static int count=0;
    private int id;
    private CountDownLatch doneCountLatch;

    @Override
    public void run() {
        String currentThreadName = Thread.currentThread().getName();
        System.out.println("#####[" +currentThreadName +"] <TASK-"+id +"> Starting ######");

        for (int i = 10; i >0 ; i--) {
            System.out.println("["+ currentThreadName+"]<Task-"+id+">Tick-Tick "+i);
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){

            }
        }

        System.out.println("#####[" +currentThreadName +"] <TASK-"+id +"> Ending ######");

        if(null != doneCountLatch){
             doneCountLatch.countDown();
            System.out.println("#####[" +currentThreadName +"] <TASK-"+id +"> Latch Count = "+doneCountLatch.getCount()
                                       +" ######");
        }
    }

    public LoopTaskH(CountDownLatch doneCountLatch){
        this.doneCountLatch = doneCountLatch;
        this.id = ++count;
    }
}
