package Programs.src.threads.executors.common;

public class LoopTaskC implements Runnable{

    private static int count=0;
    private int id;

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
    }

    public LoopTaskC(){
        this.id = ++count;
    }
}
