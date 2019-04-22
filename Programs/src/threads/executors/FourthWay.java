package Programs.src.threads.executors;

//In this class, we are starting thread by using Runnable interface in main Method with thread reference.

public class FourthWay {

    public static void main(String[] args) {
        System.out.println("Main Thread Starts.");
        new Thread(new FourthTask()).start();
        Thread t = new Thread(new FourthTask());
        t.start();
        System.out.println("Main Thread Ends.");
    }
}

class FourthTask implements Runnable{
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

    FourthTask(){
        this.id = ++count;
    }
}
