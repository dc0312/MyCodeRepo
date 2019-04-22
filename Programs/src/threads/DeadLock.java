package Programs.src.threads;

class A{
    public synchronized void m1(B b){
        System.out.println("Calling m1 method with B object lock");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        b.last();
    }

    public synchronized  void last(){
        System.out.println("Calling Last method of A Class");
    }
}

class B{
    public synchronized void m2(A a){
        System.out.println("Calling m2 method with A object lock");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        a.last();
    }

    public  synchronized  void last(){
        System.out.println("Calling Last method of B Class");
    }
}

public class DeadLock {

    public static void main(String[] args) {
        A a = new A();
        B b = new B();

        new Thread(){
            @Override
            public void run() {
                a.m1(b);
            }
        }.start();//T1 thread is waiting for the lock of b object but the lock of B object is with T2 Thread.

        new Thread(){
            @Override
            public void run() {
                b.m2(a);
            }
        }.start(); //T2 thread is waiting for the lock of a object but the lock of A object is with T1 Thread.

    }
}
