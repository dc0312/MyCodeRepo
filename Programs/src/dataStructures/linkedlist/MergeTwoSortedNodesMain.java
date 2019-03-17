package dataStructures.linkedlist;
class Link7{
	int data;
	Link7 next;
	
	Link7( int data){
		this.data = data;
	}
}

class MergeTwoSortedNodesLL{
	public Link7 first;
	
	public MergeTwoSortedNodesLL() {
		first = null;
	}
	
	public void insertFirst(int dd) {
		Link7 newLink = new Link7(dd);
		newLink.next=first;
		first = newLink;
	}
	
	public void displayList() {
		Link7 current = first;
		while(current != null) {
			System.out.println("Data :"+current.data);
			current = current.next;
		}
	}
}

public class MergeTwoSortedNodesMain {
	
	public static MergeTwoSortedNodesLL mergeSortedLink(MergeTwoSortedNodesLL ll1, MergeTwoSortedNodesLL ll2) {
		Link7 l1 = ll1.first;
		Link7 l2 = ll2.first;
		MergeTwoSortedNodesLL ll3 = new MergeTwoSortedNodesLL();
		
		if(l1.data < l2.data) {
			ll3 = ll1;
			l1 = l1.next;
		}else {
			ll3 = ll2;
			l2 = l2.next;
		}
		
		Link7 l3 = ll3.first;
		while(null != l1 && null != l2) {
			if(l1.data < l2.data) {
				l3.next = l1;
				l1 = l1.next;
			}else {
				l3.next = l2;
				l2 = l2.next;
			}
			l3 = l3.next;
		}
		return ll3;
		
	}
	public static void main(String[] args) {
		MergeTwoSortedNodesLL l1 = new MergeTwoSortedNodesLL();
		MergeTwoSortedNodesLL l2 = new MergeTwoSortedNodesLL();
		
		l1.insertFirst(5);
		l1.insertFirst(3);
		l1.insertFirst(1);
		
		l2.insertFirst(6);
		l2.insertFirst(4);
		l2.insertFirst(2);
		
		MergeTwoSortedNodesLL sortedLink = MergeTwoSortedNodesMain.mergeSortedLink(l1, l2);
		
		sortedLink.displayList();
	}
}
