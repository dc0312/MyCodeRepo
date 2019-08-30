package com.dc.data.structures.queue;

import java.util.NoSuchElementException;

public class ArrayQueue {

    private int front;
    private int back;
    private Integer [] queue;

    ArrayQueue(int size){
        queue = new Integer[size];
        front =0;
        back =0;
    }

    public void add(int data){
        //Resizing Logic
        if(size()==queue.length-1){
            int nElems = size();
            Integer [] tempqueue = new Integer[2* queue.length];
            System.arraycopy(queue,front,tempqueue,0,queue.length-front);
            System.arraycopy(queue,0,tempqueue,queue.length-front,back);
            queue = tempqueue;

            front =0;
            back = nElems;
        }
        queue[back] = data;
        if(back<queue.length-1){
            back++;
        }else{
            back=0;
        }
    }

    public int remove(){
        if(size()==0){
            throw new NoSuchElementException();
        }
        int temp = queue[front];
        queue[front] = null;
        front++;

        if(size()==0){
            back=0;
            front=0;
        }else if(front == queue.length){
            front =0;
        }
        return temp;
    }

    public int peek(){
        if(size()==0){
            throw new NoSuchElementException();
        }
        int temp = queue[front];
        return temp;
    }

    public int size(){
        if(front <=back){
            return back - front;
        }else{
            return back-front+queue.length;
        }

    }

    public void displayQueue(){
        if(front<=back){
            for(int i = front; i<back;i++){
                System.out.println(queue[i]);
            }
        }else{
            for(int i = front; i<queue.length;i++){
                System.out.println(queue[i]);
            }
            for(int i =0; i<back;i++){
                System.out.println(queue[i]);
            }
        }

    }
}
