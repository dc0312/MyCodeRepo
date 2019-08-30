package com.dc.data.structures.queue;

public class Main {

    public static void main(String[] args) {

        ArrayQueue arrayQueue = new ArrayQueue(5);
        arrayQueue.add(10);
        arrayQueue.add(20);
        arrayQueue.remove();
        arrayQueue.add(30);
        arrayQueue.remove();
        arrayQueue.add(40);
        arrayQueue.remove();
        arrayQueue.add(50);
        arrayQueue.add(60);
        arrayQueue.add(60);

        arrayQueue.displayQueue();

        /*arrayQueue.remove();
        arrayQueue.remove();

        arrayQueue.displayQueue();

        arrayQueue.peek();

        arrayQueue.remove();
        arrayQueue.remove();
        arrayQueue.remove();
        //arrayQueue.remove();
        arrayQueue.add(100);
        arrayQueue.displayQueue();*/
    }
}
