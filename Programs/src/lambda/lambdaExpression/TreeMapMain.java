package lambda.lambdaExpression;

import java.util.TreeMap;

public class TreeMapMain {
    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap<>((i1,i2) -> i1 > i2 ? -1 : i1 < i2 ? 1 : 0);
        map.put(1,"Deepak");
        map.put(2,"Aditya");

        System.out.println(map);
    }
}
