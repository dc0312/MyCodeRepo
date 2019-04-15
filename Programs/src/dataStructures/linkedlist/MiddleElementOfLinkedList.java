package dataStructures.linkedlist;
class Link4{
	public int data;
	public Link4 next;
	
	Link4(int dd){
		data=dd;
	}
}

class MiddleLinkedList{
	public Link4 first;
	
	public MiddleLinkedList() {
		first =null;
	}
	
	public void insertFirst(int i) {
		Link4 newLink = new Link4(i);
		newLink.next = first;
		first = newLink;
	}
	
	public int findMiddle() {
		Link4 current = first;
		Link4 middle = first;
		int length = 0;
		
		while(current.next != null){
	          length++;
	          if(length%2 ==0){
	              middle = middle.next;
	          }
	          current = current.next;
	      }
	    
		return null != middle ? middle.data : null;
		
		
		//Apporach 2 with Hare and Tortoise algorithm
		/*Link4 fast = first;
		Link4 slow = first;
		
		while(fast!= null && fast.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow.data;*/
		
	}
}
public class MiddleElementOfLinkedList {

	public static void main(String[] args) {
		MiddleLinkedList middleLinkedList = new MiddleLinkedList();
		middleLinkedList.insertFirst(6);
		middleLinkedList.insertFirst(5);
		middleLinkedList.insertFirst(4);
		middleLinkedList.insertFirst(3);
		middleLinkedList.insertFirst(2);
		middleLinkedList.insertFirst(1);
		
		System.out.println("Middle :"+middleLinkedList.findMiddle());
	}
}
