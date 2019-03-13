package dataStructures.linkedlist;

class Link1{
	public int data;
	public Link1 next;
	
	Link1(int dd){
		data =dd;
	}
}

class LinkList1{
	private Link1 first;
	
	public LinkList1() {
		first = null;
	}
	
	public void insert(int key) {
		Link1 newLink = new Link1(key);
		Link1 current = first;
		Link1 previous = null;
		
		while(current != null && key > current.data) {
			previous = current;
			current = current.next;
		}
		
		if(previous == null) {
			first = newLink;
		}else {
			previous.next = newLink;
		}
		newLink.next=current;
	}
	
	public void displayList() {
		Link1 current = first;
		while(current != null) {
			System.out.println("Data : "+current.data);
			current = current.next;
		}
	}
}
public class SortedLinkList {
	
	
	public static void main(String[] args) {
		LinkList1 soLinkList1 = new LinkList1();
		
		soLinkList1.insert(10);
		soLinkList1.insert(1);
		soLinkList1.insert(12);
		soLinkList1.insert(7);
		
		soLinkList1.displayList();
	}
}
