package com.dc.data.structures.stack;

import java.util.EmptyStackException;

public class StackArray {

    public int [] stack;
    public int top;
    public int maxSize;

    StackArray(int length){
        maxSize = length;
        stack = new int[maxSize] ;
        top = -1;
    }

    public void push(int data){
        //if the stack is full, we have to resize the array
        if(isFull()){

            System.out.println("Array is full. resizing the array.");
            int [] tempArray = new int[2*maxSize];
            System.arraycopy(stack,0,tempArray,0,maxSize);
            stack = tempArray;
        }
        stack[++top] = data;
    }

    public int pop(){
        if(isEmpty()){
            throw  new EmptyStackException();
        }
        return stack[top--];
    }

    public int peek(){
        if(isEmpty()){
            throw  new EmptyStackException();
        }
        return stack[top];
    }

    public boolean isEmpty(){
        return top==-1;
    }

    public boolean isFull(){
        return top==maxSize-1;
    }

    public void displayStack(){
        for(int i =0; i<=top;i++){
            System.out.println(stack[i]);
        }
    }
}
