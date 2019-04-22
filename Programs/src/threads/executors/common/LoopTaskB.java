package Programs.src.threads.executors.common;

public class LoopTaskB implements Runnable{

    private static int count=0;
    private int id;

    @Override
    public void run() {
        Thread.currentThread().setName("Amazing Thread "+id);
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

    public LoopTaskB(){
        this.id = ++count;
    }
}
