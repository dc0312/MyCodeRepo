package lambda.predicate;

import java.util.function.Predicate;

public class PredicateExample1 {
    public static void main(String[] args) {
        String [] names = {"Deepak","Adiya","Dhruv","Kannu"};
        Predicate<String> condtion = s -> s.startsWith("D");

        for(String name : names){
            if(condtion.test(name)){
                System.out.print(name+",");
            }
        }
        System.out.println();
    }
}
