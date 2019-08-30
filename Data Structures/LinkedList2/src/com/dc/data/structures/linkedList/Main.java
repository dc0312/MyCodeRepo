package com.dc.data.structures.linkedList;

public class Main {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.first = new Link(1);
        linkedList.first.next = new Link(2);
        linkedList.first.next.next = new Link(3);
        linkedList.first.next.next.next = new Link(4);
        linkedList.first.next.next.next.next = new Link(5);
        linkedList.first.next.next.next.next.next = new Link(6);
        linkedList.first.next.next.next.next.next.next = linkedList.first.next.next;
        /*linkedList.insertFirst(20);
        linkedList.insertFirst(30);
        linkedList.insertFirst(30);
        linkedList.insertFirst(20);
        linkedList.insertFirst(10);
        linkedList.insertLast(10);*/


        /*linkedList.display();
        //System.out.println(linkedList.findNthLink(1));
        //System.out.println(linkedList.findMidLink());
        System.out.println(linkedList.isPalindrome());
        linkedList.removeDuplicates();
        linkedList.display();*/

        System.out.println(linkedList.findCycle());
        System.out.println(linkedList.findCycleLink());
        linkedList.removeCycle();
        linkedList.display();
    }
}
