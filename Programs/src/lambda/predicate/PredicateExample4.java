package lambda.predicate;

import java.util.function.Predicate;

public class PredicateExample4 {
    public static void main(String[] args) {
        Predicate<String> p = Predicate.isEqual("Deepak");
        System.out.println(p.test("Deepak"));
        System.out.println(p.test("DC"));
    }
}
