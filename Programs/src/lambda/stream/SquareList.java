package lambda.stream;

import java.util.Arrays;
import java.util.List;

public class SquareList {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1,2,3,4,5);
        nums.stream().map(i -> i*i).forEach(System.out::println);
    }
}
