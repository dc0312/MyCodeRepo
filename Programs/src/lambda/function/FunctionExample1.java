package lambda.function;

import java.util.function.Function;

public class FunctionExample1 {
    public FunctionExample1(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) {
        String sentence = "Deepak is DC";
        Function<String,String> removeSpaces = s -> s.replaceAll(" ","");
        System.out.println(removeSpaces.apply(sentence));

        Function<String, Integer> countSpaces = s -> s.length() - removeSpaces.apply(sentence).length();
        System.out.println(countSpaces.apply(sentence));

        Function<String,FunctionExample1> f1 = FunctionExample1::new;
        f1.apply("Deepak as constructor.");
    }
}
