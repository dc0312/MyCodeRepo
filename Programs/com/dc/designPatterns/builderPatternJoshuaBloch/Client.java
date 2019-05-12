package Programs.com.dc.designPatterns.builderPatternJoshuaBloch;

public class Client {

    public static void main(String[] args) {

        NutritionalFacts nutritionalFacts = new NutritionalFacts.Builder(25,33)
                .calories(30).carbs(4).fats(1).sodium(1000).build();

        System.out.println(nutritionalFacts.toString());
    }
}
