package Programs.src.threads.executors;

//In this class, we are starting thread by using Runnable interface in constructors.

public class ThirdWay {

    public static void main(String[] args) {
        System.out.println("Main Thread Starts.");
        new ThirdTask();
        new ThirdTask();
        System.out.println("Main Thread Ends.");
    }
}

class ThirdTask implements Runnable{
    private static int count =0;
    private int id;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("<" + id +">Tick-Tick "+i);
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){

            }
        }
    }

    ThirdTask(){
        this.id = ++count;
        new Thread(this).start();
    }
}
