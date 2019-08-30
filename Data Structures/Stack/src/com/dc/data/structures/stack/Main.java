package com.dc.data.structures.stack;

public class Main {

    public static void main(String[] args) {
        StackArray stackArray = new StackArray(4);
        stackArray.push(10);
        stackArray.push(20);
        stackArray.push(20);
        stackArray.push(20);
        stackArray.displayStack();
        stackArray.push(30);
        stackArray.displayStack();
        System.out.println(stackArray.pop()+" item deleted.");
        stackArray.displayStack();
    }
}
