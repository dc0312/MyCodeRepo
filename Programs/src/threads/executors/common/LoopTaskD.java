package Programs.src.threads.executors.common;

public class LoopTaskD implements Runnable{

    private static int count=0;
    private int id;
    private String taskId;

    private volatile boolean shutdown = false;

    @Override
    public void run() {
        String currentThreadName = Thread.currentThread().getName();
        System.out.println("#####[" +currentThreadName +"] < "+taskId +"> Starting ######");

        for (int i =0;; i--) {
            System.out.println("["+ currentThreadName+"]< "+taskId+">Tick-Tick "+i);
            try {
                Thread.sleep(3000);
            }catch (InterruptedException e){

            }

            synchronized (this){
                if(shutdown){
                    break;
                }
            }
        }


        System.out.println("#####[" +currentThreadName +"] < "+taskId +"> Ending ######");
    }

    public void cancel(){
        System.out.println("["+Thread.currentThread().getName()+"] <"+taskId+" Cancelling it !!!");
        synchronized (this){
            this.shutdown = true;
        }
    }

    public LoopTaskD(){
        this.id = ++count;
        this.taskId = "LoopTaskD -"+id;
    }
}
