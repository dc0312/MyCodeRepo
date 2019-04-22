package Programs.src.threads.executors;

//In this class, we are starting thread from constructor.

public class FirstWay {

    public static void main(String[] args) {
        System.out.println("Main Thread Starts.");
        new FirstTask();
        Thread t = new FirstTask();
        System.out.println("Main Thread Ends.");
    }
}

class FirstTask extends Thread{
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

    FirstTask(){
        this.id = ++count;
        this.start();
    }
}
