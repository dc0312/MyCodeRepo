package hackerRank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CompareTriplets {

	// Complete the compareTriplets function below.
	static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
		/*Map<String, Integer> compMap = new HashMap<>();
		compMap.put("A", 0);
		compMap.put("B", 0);*/
		int A =0;
		int B =0;

		for (int i = 0; i < a.size(); i++) {
			if (a.get(i) > b.get(i)) {
				A++;
				//compMap.put("A", compMap.get("A") + 1);
			} else if (a.get(i) < b.get(i)) {
				B++;
				//compMap.put("B", compMap.get("B") + 1);
			}
		}
		List<Integer> compare = new ArrayList<>();
		//compare.add(compMap.get("A"));
		//compare.add(compMap.get("B"));
		compare.add(A);
		compare.add(B);

		return compare;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt)
				.collect(toList());

		List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt)
				.collect(toList());

		List<Integer> result = compareTriplets(a, b);

		for (Integer i : result) {
			System.out.print(i + " ");
		}

		bufferedReader.close();
	}
}
