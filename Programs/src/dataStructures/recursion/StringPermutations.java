package dataStructures.recursion;

import java.util.TreeSet;

public class StringPermutations {
	
	private static TreeSet treeSet = new TreeSet<>();
	public static void main(String args[]) {
		permutation("ABC");
	}

	public static void permutation(String input) {
		TreeSet treeSet = permutation("", input);
		System.out.println(treeSet);
	}

	private static TreeSet permutation(String perm, String word) {
		if (word.isEmpty()) {
			treeSet.add(perm);
			System.out.println("word :"+perm);
		} else {
			for (int i = 0; i<word.length(); i++) {
				System.out.println("for ke andar");
				System.out.println("permutation("+perm + word.charAt(i)+","+ word.substring(0, i) + word.substring(i + 1, word.length())+")");
				System.out.println("i "+i);
				permutation(perm + word.charAt(i), word.substring(0, i) + word.substring(i + 1, word.length()));
			}
		}
		System.out.println("return");
		return treeSet;

	}
}
