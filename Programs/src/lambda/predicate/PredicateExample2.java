package lambda.predicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

public class PredicateExample2 {
    public static void main(String[] args) {
        String [] names = {"Durga",null , "", "Deepak"," "};

        Predicate<String> condition = s -> s != null && s.trim().length() != 0 ;

        ArrayList<String> al = new ArrayList<>();
        for(String s : names){
            if(condition.test(s)){
                al.add(s);
            }
        }
        System.out.println(al);
    }
}
