package com.dc.data.structures.linkedList;

public class Main {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        /*linkedList.insert(40);
        linkedList.insert(30);
        linkedList.insert(20);
        linkedList.insert(10);
        linkedList.insertLast(50);
        linkedList.insertLast(60);
        linkedList.insertLast(70);*/

        /*linkedList.insertLast(1);
        linkedList.insertLast(2);
        linkedList.insertLast(3);
        //linkedList.insertLast(3);
        linkedList.insertLast(2);
        linkedList.insertLast(1);*/

        linkedList.first = new Link(1);
        linkedList.first.next = new Link(2);
        linkedList.first.next.next = new Link(3);
        linkedList.first.next.next.next = new Link(4);
        linkedList.first.next.next.next.next = new Link(5);
        linkedList.first.next.next.next.next.next = new Link(6);
        //linkedList.first.next.next.next.next.next.next = linkedList.first.next;


        /*linkedList.display();
        System.out.println("Length : "+linkedList.counter);
        //System.out.println(linkedList.deleteFirst());
        System.out.println(linkedList.findNthLink(1));

        System.out.println(linkedList.findMidLink());*/

        //System.out.println(linkedList.findPalindrome());

        //linkedList.removeDuplicates();
        //linkedList.display();
        System.out.println(linkedList.findCycle());
    }
}
