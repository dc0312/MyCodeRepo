package lambda.lambdaExpression;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListMain {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(10);
        al.add(0);
        al.add(15);
        al.add(12);
        al.add(8);

        System.out.println(al);

        Collections.sort(al, (i1,i2) -> i1 > i2 ? -1 : i1 < i2 ? 1 : 0);

        System.out.println(al);

        Collections.sort(al, (i1,i2) -> i1 > i2 ? 1 : i1 < i2 ? -1 : 0);

        System.out.println(al);
    }
}
