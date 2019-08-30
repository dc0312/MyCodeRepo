package com.dc.data.structures.linkedList;

class Stack {
    private class Link{
        int data;
        Link next;
        Link oldmax;

        public void displayLink(){
            System.out.print(data+"->");
        }

        @Override
        public String toString() {
            return "Data ->"+data;
        }
    }

    private Link stack;
    private Link max;

    public void push(int dd){
        Link newLink = new Link();
        newLink.data = dd;

        if(stack == null){
            stack = newLink;
            max = newLink;
        }else{
            newLink.next = stack;
            stack = newLink;
        }

        if(max == null || newLink.data > max.data ){
            newLink.oldmax = max;
            max = newLink;
        }
    }

    public void display(){
        Link current = stack;
        while(current != null){
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }

    public int pop(){
        Link temp = stack;
        stack = temp.next;
        if(temp.oldmax != null) {
            max = temp.oldmax;
        }
        return temp.data;
    }

    public int max(){
        return max.data;
    }
}
public class Main {

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        stack.display();
        System.out.println(stack.max());

        System.out.println(stack.pop());

        System.out.println(stack.max());
    }
}
