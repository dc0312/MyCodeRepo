package dataStructures.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortArrayUsingComparator {
	
	public static void main(String[] args) {
		int [] arr = new int[4];
		arr[0]=10;
		arr[1]=10;
		arr[2]=3;
		arr[3]=6;
		List<Integer> array = Arrays.stream(arr).boxed().collect(Collectors.toList());
		Collections.sort(array, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2)>0 ? 1:-1;
			}
		});
		
		for (Integer integer : array) {
			System.out.println(integer);
		}
	}

}
