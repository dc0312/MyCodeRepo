package dataStructures.recursion;

public class TowerOfHanoi {
	public static void main(String[] args) {
		logic(2, 'A', 'B', 'C');
	}
	
	public static void  logic(int nDisks, char from , char inter, char to) {
		if(nDisks == 1) {
			System.out.println("Move Disk "+ nDisks+" from "+from +" to "+to);
		}else {
			logic(nDisks-1, from, to, inter);
			System.out.println("Move Disk "+ nDisks+" from "+from +" to "+to);
			logic(nDisks -1, inter, from, to);
		}
	}
}
