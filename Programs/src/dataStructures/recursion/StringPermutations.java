package dataStructures.recursion;

import java.util.TreeSet;

public class StringPermutations {
	
	private static TreeSet hashSet = new TreeSet<>();
	public static void main(String args[]) {
		permutation("AABC");
	}

	public static void permutation(String input) {
		TreeSet hashSet = permutation("", input);
		System.out.println(hashSet);
	}

	private static TreeSet permutation(String perm, String word) {
		if (word.isEmpty()) {
			hashSet.add(perm + word);
		} else {
			for (int i = 0; i<word.length(); i++) {
				permutation(perm + word.charAt(i), word.substring(0, i) + word.substring(i + 1, word.length()));
			}
		}
		return hashSet;

	}
}
