package lambda.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapExample {
    public static void main(String[] args) {
        //given a list [1,2,3] and a list [3,4], you should return all the pairs
        List<Integer> nums1 = Arrays.asList(1,2,2);
        List<Integer> nums2 = Arrays.asList(2,2);

        List<int[]> pairs = nums1.stream().flatMap(
                i-> nums2.stream().map(j -> new int[] {i,j})
        ).collect(Collectors.toList());

        pairs.stream().map(Arrays::toString).forEach(System.out::println);
        System.out.println("*********************************************");
        //return only pairs whose sum is divisible by 3
        List<int[]> pairs2 = nums1.stream().flatMap(
                i-> nums2.stream().filter(j -> (i+j)%3==0)
                .map(j -> new int[]{i,j})
        ).collect(Collectors.toList());
        pairs2.stream().map(Arrays::toString).forEach(System.out::println);
        System.out.println("*********************************************");
        //return pairs whose sum is equal to 6
        List<int []> pairs3 = nums1.stream().flatMap(
                i -> nums2.stream().filter(j -> (i+j)==4).map(j -> new int[]{i,j})
        ).collect(Collectors.toList());
        pairs3.stream().map(Arrays::toString).forEach(System.out::println);
    }
}
