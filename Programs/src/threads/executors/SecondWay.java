package Programs.src.threads.executors;

//In this class, we are starting thread by using start method.

public class SecondWay {

    public static void main(String[] args) {
        System.out.println("Main Thread Starts.");
        new SecondTask().start();
        Thread t = new SecondTask();
        t.start();
        System.out.println("Main Thread Ends.");
    }
}

class SecondTask extends Thread{
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

    SecondTask(){
        this.id = ++count;
    }
}
