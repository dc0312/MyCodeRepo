package lambda.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork",false,800,Type. MEAT),
                new Dish("beef",false,700,Type. MEAT),
                new Dish("chicken",false,400,Type. MEAT),
                new Dish("french fries",true,530,Type. OTHER),
                new Dish("rice",true,350,Type. OTHER),
                new Dish("season fruit",true,120,Type. OTHER),
                new Dish("pizza",true,550,Type. OTHER),
                new Dish("prawns",false,300,Type. FISH),
                new Dish("salmon",false,450,Type. FISH)
        );

        menu.stream().filter(c -> c.getCalories() > 300).sorted(Comparator.comparing(Dish::getName)).limit(3).forEach(System.out::println);
        System.out.println("*******************************************************");
        List<Dish> vegetarianDishes = menu.stream().filter(Dish::isVegetarian).collect(Collectors.toList());
        vegetarianDishes.stream().forEach(System.out::println);
    }
}
