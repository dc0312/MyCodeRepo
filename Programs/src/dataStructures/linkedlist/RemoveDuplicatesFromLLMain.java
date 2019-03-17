package dataStructures.linkedlist;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

class Link5{
	public int data;
	public Link5 next;
	
	Link5(int dd){
		data=dd;
	}
}

class RemoveDuplicatesFromLL{
	public Link5 first;
	
	public RemoveDuplicatesFromLL() {
		first = null;
	}
	
	public void insert(int i) {
		Link5 newLink = new Link5(i);
		newLink.next = first;
		first = newLink;
	}
	
	public void displayList() {
		Link5 current = first;
		while(current != null) {
			System.out.println("Data :"+current.data);
			current = current.next;
		}
	}
	
}
public class RemoveDuplicatesFromLLMain {
	
	/**
	 * @param dupLL
	 */
	public static void removeDuplicates(RemoveDuplicatesFromLL dupLL) {
		HashSet<Integer> linkSet = new HashSet<>();
		Link5 cuLink5 = dupLL.first;
		Link5 previous = null;
		while(cuLink5 != null) {
			if(linkSet.contains(cuLink5.data)) {
				previous.next = cuLink5.next;
			}else {
				linkSet.add(cuLink5.data);
				previous = cuLink5;
			}
			cuLink5 = cuLink5.next;
		}
		
	}
	
	public static void main(String[] args) {
		RemoveDuplicatesFromLL duplicatesFromLL = new RemoveDuplicatesFromLL();
		duplicatesFromLL.insert(10);
		duplicatesFromLL.insert(12);
		duplicatesFromLL.insert(10);
		duplicatesFromLL.insert(13);
		duplicatesFromLL.insert(5);
		duplicatesFromLL.insert(10);
		
		duplicatesFromLL.displayList();
		
		System.out.println("=====================");
		RemoveDuplicatesFromLLMain.removeDuplicates(duplicatesFromLL);
		
		duplicatesFromLL.displayList();
		
	}

}
