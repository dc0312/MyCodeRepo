package Programs.src.threads.executors.common;

import sun.awt.windows.ThemeReader;

public class LoopTaskA implements Runnable{

    private static int count=0;
    private int id;

    @Override
    public void run() {
        System.out.println("##### <TASK-"+id +"> Starting ######");

        for (int i = 10; i >0 ; i--) {
            System.out.println("<Task-"+id+">Tick-Tick "+i);
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
                break;
            }
        }

        System.out.println("****** <TASK-"+id +"> Done ******");
    }

    public LoopTaskA(){
        this.id = ++count;
    }
}
