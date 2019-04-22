package Programs.src.threads.executors.common;

import java.util.*;

public class LoopTaskF implements Runnable{

    private static int count=0;
    private int id;
    private String taskId;

    @Override
    public void run() {
        String currentThreadName = Thread.currentThread().getName();
        System.out.println("#####[" +currentThreadName +"] < "+taskId +"> Starting ######");

        for (int i =0;; i--) {
            System.out.println("["+ currentThreadName+"]< "+taskId+">Tick-Tick "+i);

            doSomeWork();

            if(Thread.interrupted()){
                System.out.println("["+Thread.currentThread().getName()+"] < "+taskId+ " Interrupted ...Cancelling it.");
                break;
            }

        }


        System.out.println("#####[" +currentThreadName +"] < "+taskId +"> Ending ######");
    }

    public void doSomeWork(){
        for(int i=0; i<2;i++){
            Collections.sort(generateDataSet());
        }
    }

    public List<Integer> generateDataSet(){
        List<Integer> intList = new ArrayList<Integer>();

        Random random = new Random();

        for(int i =0; i<10000; i++){
            intList.add(random.nextInt()*10000);
        }

        return intList;
    }

    public LoopTaskF(){
        this.id = ++count;
        this.taskId = "LoopTaskF -"+id;
    }
}
