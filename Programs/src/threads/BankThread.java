package Programs.src.threads;

class BankAccount1{
    int accountNumber;
    static int balance;


    BankAccount1(int accountNumber, int balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    synchronized void withDraw(int amount){
        if(this.balance < amount){
            try {
                System.out.println("There is not enough balance in the account");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
            this.balance = this.balance-amount;
            System.out.println("Balance after withdraw :"+balance);
        }
    }

    synchronized void deposit(int amount){
        System.out.println("Deposit the ammount : "+amount);
        balance = balance + amount;

        System.out.println("Balance after deposit :"+balance);
        notifyAll();
    }
}
public class BankThread {

    public static void main(String[] args) {
        final BankAccount1 bankAccount1 = new BankAccount1(1000,10000);

        new Thread(){
            @Override
            public void run() {
                bankAccount1.withDraw(15000);
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                bankAccount1.deposit(8000);
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                bankAccount1.withDraw(15000);
            }
        }.start();

    }
}
