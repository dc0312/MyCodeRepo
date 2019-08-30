package com.dc.data.structures.doubleLinkList;
class Link{
    public int data;
    public Link next;

    Link(int data){
        this.data = data;
    }

    public void displayLink(){
        System.out.print(data+" -> ");
    }
}

class LinkedList{
    public Link first;
    public Link last;

    LinkedList(){
        first = null;
        last= null;
    }

    public void insertFirst(int dd){
        Link newLink = new Link(dd);
        if(first==null){
            last = newLink;
        }
        newLink.next = first;
        first = newLink;
    }

    public void insertLast(int dd){
        Link newLink = new Link(dd);
        if(first == null){
            first = newLink;
        }else{
            last.next = newLink;
        }
        last  = newLink;
    }

    public Link deleteFirst(){
        Link temp = first;
        if(first.next == null){
            last = null;
        }
        first = first.next;
        return temp;
    }

    public void display(){
        Link curLink = first;
        while(curLink != null){
            curLink.displayLink();
            curLink = curLink.next;
        }
    }
}
public class Main {

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertFirst(5);
        ll.insertLast(10);
        ll.insertLast(15);
        ll.display();

    }
}
