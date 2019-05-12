package Programs.src.practice2;

public class Dog extends AbstractAnimal implements Animal,Animal1 {
    @Override
    public void eat() {
        System.out.println("Dog Eats");
    }

    @Override
    public void drink() {

        System.out.println("Dog Drink");
    }
}
