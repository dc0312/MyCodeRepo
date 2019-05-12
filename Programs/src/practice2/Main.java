package Programs.src.practice2;

public class Main {

    public static void main(String[] args) {
        Dog d = new Dog();

        Cat c = new Cat();

        Animal a1 = new Dog();

        Animal a2 = new Cat();

        AbstractAnimal a3 = new Dog();

        d.eat();
        c.eat();
        a1.eat();
        a2.eat();

        a3.eat();


        d.drink();

    }
}
