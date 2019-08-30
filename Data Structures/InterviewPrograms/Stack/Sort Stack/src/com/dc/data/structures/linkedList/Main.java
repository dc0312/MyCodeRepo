package com.dc.data.structures.linkedList;

import java.util.Stack;

public class Main {

    private static Stack sortStack(Stack<Integer> stack){
        Stack<Integer> newStack = new Stack<>();
        newStack.push(stack.pop());

        while(!stack.isEmpty()){
            int temp = stack.pop();
            while(!newStack.isEmpty() && temp > newStack.peek()){
                stack.push(newStack.pop());
            }
            newStack.push(temp);
        }
        return newStack;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(4);
        stack.push(2);
        stack.push(3);
        stack.push(1);

        Stack<Integer> newStack = sortStack(stack);

        System.out.println(newStack.pop());
        System.out.println(newStack.pop());
        System.out.println(newStack.pop());
        System.out.println(newStack.pop());
    }
}
