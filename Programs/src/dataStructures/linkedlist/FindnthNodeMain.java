package dataStructures.linkedlist;
class Link6{
	public int data;
	Link6 next;
	
	Link6(int data){
		this.data = data;
	}
}

class FindnthNodeLL{
	public Link6 first;
	
	public FindnthNodeLL() {
		first = null;
	}
	
	public void insertFirst(int dd) {
		Link6 newLink = new Link6(dd);
		newLink.next = first;
		first = newLink;
	}
	
	public void displayList() {
		Link6 current = first;
		while(current != null) {
			System.out.println("Data :"+current.data);
			current = current.next;
		}
	}
	
}
public class FindnthNodeMain {
	public int findNode(FindnthNodeLL findnthNodeLL,int node) {
		Link6 fast = findnthNodeLL.first;
		Link6 slow = findnthNodeLL.first;
		int count =1;
		while(node > count) {
			count++;
			fast = fast.next;
		}
		
		while(fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		
		return slow.data;
		
	}
	public static void main(String[] args) {
		FindnthNodeMain findnthNodeMain = new FindnthNodeMain();
		FindnthNodeLL findnthNodeLL = new FindnthNodeLL();
		findnthNodeLL.insertFirst(10);
		findnthNodeLL.insertFirst(9);
		findnthNodeLL.insertFirst(8);
		findnthNodeLL.insertFirst(7);
		findnthNodeLL.insertFirst(6);
		findnthNodeLL.insertFirst(5);
		findnthNodeLL.insertFirst(4);
		findnthNodeLL.insertFirst(3);
		findnthNodeLL.insertFirst(2);
		findnthNodeLL.insertFirst(1);
		
		findnthNodeLL.displayList();
		
		System.out.println("==================");
		System.out.println(findnthNodeMain.findNode(findnthNodeLL, 3));
	}
}
