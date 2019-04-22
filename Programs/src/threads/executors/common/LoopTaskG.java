package Programs.src.threads.executors.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LoopTaskG implements Runnable{

    private static int count=0;
    private int id;
    private String taskId;

    @Override
    public void run() {
        String currentThreadName = Thread.currentThread().getName();
        System.out.println("#####[" +currentThreadName +"] < "+taskId +"> Starting ######");

        for (int i =0;; i--) {
            System.out.println("["+ currentThreadName+"]< "+taskId+">Tick-Tick "+i);

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("["+Thread.currentThread().getName()+"] < "+taskId+ " Interrupted ...Cancelling it.");
                break;
            }
        }


        System.out.println("#####[" +currentThreadName +"] < "+taskId +"> Ending ######");
    }


    public LoopTaskG(){
        this.id = ++count;
        this.taskId = "LoopTaskG -"+id;
    }
}
