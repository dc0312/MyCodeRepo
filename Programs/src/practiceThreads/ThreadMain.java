package Programs.src.practiceThreads;

import sun.awt.windows.ThemeReader;

import java.util.Random;

public class ThreadMain {

    public static void main(String[] args) {
        Message message = new Message();
        (new Thread(new Writer(message))).start();
        (new Thread(new Reader(message))).start();

    }
}

class Message {
    String message;
    private boolean empty = true;

    public synchronized String read() {
        while (empty) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        empty = true;
        notifyAll();
        return message;
    }

    public synchronized void write(String message) {
        while (!empty) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        empty = false;
        this.message = message;
        notifyAll();
    }
}
    class Writer implements Runnable{

        Message message = new Message();

        public Writer(Message message){
            this.message = message;
        }
        @Override
        public void run() {
            String [] messages = {
                    "Deepak is testing writer",
                    "Deepak is inside writer method",
                    "Deepak is implementing Runnable interface in writer"
            };


            for(int i=0;i<messages.length;i++){
                message.write(messages[i]);
                try{
                    Thread.sleep(2000);
                }catch (InterruptedException e){

                }
            }
            message.write("Finished");
        }
    }

    class Reader implements Runnable{
        private Message message;

        public Reader(Message message){
            this.message= message;
        }

        @Override
        public void run() {
            for(String latestMessage = message.read();!latestMessage.equals("Finished");latestMessage=message.read()){
                System.out.println(latestMessage);
                try {
                    Thread.sleep(2000);
                }catch (InterruptedException e){

                }
            }
        }
    }

