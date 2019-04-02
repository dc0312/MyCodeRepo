package programs;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestMain implements Test1,Test2{

	@Override
	public void test() {
		// TODO Auto-generated method stub Method 
		System.out.println("***************TestMethod called********************");
		
	}
	
	public static void main(String[] args) {
		Integer i1 = new Integer(10);
		Integer i2 = new  Integer(10);
		
		if(i1 != i2) {
			System.out.println("No equal");
		}
		if(i1 == i2) {
			System.out.println("Equal");
		}
		if(i1.equals(i2)) {
			System.out.println("Equal :equal");
		}
		
		List<String> title = Arrays.asList("Java8","In","Action");
		Stream<String> s = title.stream();
		s.forEach(System.out::println);
		
		List<Integer> titleLength = title.stream()
											.map(String::length)
											.collect(Collectors.toList());
		System.out.println(titleLength);
		
		List<String> uniqueElements = title.stream()
											.map(t -> t.toLowerCase().split(""))
											.flatMap(Arrays::stream)
											.distinct()
											.collect(Collectors.toList());
		System.out.println(uniqueElements);
		
		List<Integer> numbers = Arrays.asList(1,2,3,4,5);
		List<Integer> squareNumbers = numbers.stream()
												.map(n -> n*n)
												.collect(Collectors.toList());
		
		System.out.println(squareNumbers);
		
		List<Integer> numbers1 = Arrays.asList(1,2,3);
		List<Integer> numbers2 = Arrays.asList(3,4);
		
		List<int[]> pairList = numbers1.stream()
										.flatMap(i->numbers2.stream()
												.map(j -> new int[] {i,j}))
										.collect(Collectors.toList());
		
		pairList.stream().map(Arrays::toString).forEach(System.out::println);
		
		TestMain main = new TestMain();
		main.testDef();
		main.test();
	}

	@Override
	public void testDef() {
		// TODO Auto-generated method stub
		//Test1.super.testDef();
	}

}
