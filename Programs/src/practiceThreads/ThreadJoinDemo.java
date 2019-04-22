package Programs.src.practiceThreads;

class Thread1 extends Thread{
    Thread2 t2 = new Thread2();
    @Override
    public void run(){
        try {
            t2.start();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" executing");
        for (int i =0; i < 5;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" : "+i);
        }
    }
}

class Thread2 extends Thread{

    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName()+" executing");
        for (int i =0; i < 5;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" : "+i);
        }
    }
}

public class ThreadJoinDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread1 t1 = new Thread1();

        t1.start();

        t1.join();

        for (int i =0; i < 5;i++){
            System.out.println(Thread.currentThread().getName()+" : "+i);
        }

    }
}
