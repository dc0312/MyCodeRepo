package com.dc.data.structures.linkedList;

import java.util.HashSet;
import java.util.Stack;

public class LinkedList {

    Link first;
    int counter;

    public void insert(int dd){
        Link newLink = new Link(dd);
        newLink.next = first;
        first = newLink;
        counter++;
    }

    public void insertLast(int dd){
        Link newLink =new Link(dd);
        if(null == first){
            first = newLink;
        }else{
            Link current = first;
            while(null != current.next ){
                current = current.next;
            }
            current.next = newLink;
        }
    }

    public Link deleteFirst(){
        Link temp = first;
        first = first.next;
        return temp;
    }

    public void display(){
        Link current = first;

        while(null != current){
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }

    public Link findNthLink(int n){
        Link fast = first;
        Link slow = first;
        int count = 0;
        for(int i =0; i<n;i++){
            if(fast == null){
                return null;
            }
            fast = fast.next;
        }
        while(null != fast){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public Link findMidLink(){
        Link fast = first;
        Link slow = first;

        while(null != fast && null != fast.next){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public boolean findPalindrome(){
        Link fast = first;
        Link slow = first;
        Stack<Integer> stack = new Stack<>();
        while(null != fast && null != fast.next){
            fast = fast.next.next;
            stack.push(slow.data);
            slow = slow.next;
        }

        if(null != fast){
            slow = slow.next;
        }

        while(null != slow){
            if(stack.pop() != slow.data){
                return false;
            }
            slow = slow.next;
        }
        return true;
    }

    public void removeDuplicates(){
        if(null == first) return;
        Link current = first;
        HashSet<Integer> links = new HashSet<>();

        Link previous = null;
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

    public boolean findCycle(){
        Link fast = first.next;
        Link slow = first;
        while(null != first && null != first.next){
            if(slow.data == fast.data){
                return true;
            }
            if(null == fast.next){
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }

    public void deleteNode(Link link){
        Link temp = link.next;
        link.data = temp.data;
        link.next = temp.next;
    }

    public void reverseLinkedList(){
        if(null == first){
            return ;
        }

        Link previous = null;
        Link current = first;
        Link nextLink ;

        while(null != current){
            nextLink = current.next;
            current.next = previous;
            previous = current;
            current = nextLink;

        }
        first = previous;


    }
}
