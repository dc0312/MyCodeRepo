package Programs.src.threads.executors;

//using Runnable Anonymous class.
public class FifthWay {

    public static void main(String[] args) {
        System.out.println("Main Method Starts.");

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Tick-Tick "+i);
                    try {
                        Thread.sleep(1000);
                    }catch (InterruptedException e){

                    }
                }
            }
        }).start();

        System.out.println("Main Method Ends.");
    }
}
