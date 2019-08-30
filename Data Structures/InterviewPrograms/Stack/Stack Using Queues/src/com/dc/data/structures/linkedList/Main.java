package com.dc.data.structures.linkedList;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;

class Stack{
    Queue<Integer> primary = new LinkedList<>();
    Queue<Integer> secondary = new LinkedList<>();

    public void push(int dd){
        secondary.add(dd);
        while(!primary.isEmpty()){
            secondary.add(primary.poll());
        }
        Queue<Integer> temp = new LinkedList<>();
        temp = secondary;
        secondary = primary;
        primary = temp;
    }

    public int pull(){
        if(primary.isEmpty()) {
            throw new EmptyStackException();
        }
        return primary.poll();
    }

}

public class Main {

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack.pull());
        System.out.println(stack.pull());
        System.out.println(stack.pull());
        System.out.println(stack.pull());
    }
}
