package com.dc.data.structures.linkedList;

import java.util.HashSet;
import java.util.Stack;

public class LinkedList {

    public Link first;

    public void insertFirst(int dd){
        Link newLink = new Link(dd);
        newLink.next = first;
        first = newLink;
    }

    public Link deleteFirst(){
        Link temp = first;
        first = first.next;
        return temp;
    }

    public void insertLast(int dd){
        Link newLink = new Link(dd);
        if(null == first){
            first = newLink;
        }else{
            Link current = first;
            while(null != current.next){
                current = current.next;
            }
            current.next = newLink;
        }
    }

    public void display(){
        Link current = first;
        while(null != current){
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }

    public int findNthLink(int n){
        Link fast = first;
        Link slow = first;

        for(int i =0; i< n && null != fast; i++){
            fast = fast.next;
        }

        if(null == fast){
            return -1;
        }
        while(null != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow.data;
    }

    public int findMidLink(){
        Link fast = first;
        Link slow = first;

        while(null != fast && null != fast.next){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.data;
    }

    public boolean isPalindrome(){
        Link fast = first;
        Link slow = first;
        Stack<Integer>  stack = new Stack<>();

        while(null != fast && null != fast.next){
            stack.push(slow.data);
            fast = fast.next.next;
            slow = slow.next;
        }

        while(null != slow){
            if(stack.peek() == slow.data){
                stack.pop();
            }
            slow = slow.next;
        }

        if(stack.isEmpty()){
            return true;
        }
        return false;
    }

    public void removeDuplicates(){
        if(null == first) return;
        Link current = first;
        Link previous = first;
        HashSet<Integer> links = new HashSet<>();
        while(null != current){
            if(links.contains(current.data)){
                previous.next = current.next;
            }else{
                links.add(current.data);
                previous = current;
            }
            current = current.next;
        }

    }

    public Link findCycle(){
        Link fast = first.next;
        Link slow = first;
        while(null != fast && null != fast.next){
            if(slow.data == fast.data){
                return slow;
            }
            if(null == fast.next){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return null;
    }

    public Link findCycleLink(){
        Link commLink = findCycle().next;
        Link current = first;
        while(commLink.data != current.data){
            current = current.next;
            commLink = commLink.next;
        }
        return current;
    }

    public void removeCycle(){
        Link commLink = findCycle().next;
        Link previousCommLink = null;
        Link cycleStartLink = findCycleLink();

        while(commLink.data != cycleStartLink.data){
            previousCommLink = commLink;
            commLink = commLink.next;
        }
        previousCommLink.next = null;

    }
}
