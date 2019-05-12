package Programs.src.practice2;

public class Cat implements Animal,Animal1 {

    @Override
    public void eat() {
        System.out.println("Cat eats");
    }

    @Override
    public void drink() {
        System.out.println("Cat drinks");
    }
}
