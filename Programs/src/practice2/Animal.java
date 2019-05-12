package Programs.src.practice2;

public interface Animal {
    //normal method
    void eat();

    default void drink(){
        System.out.println("Animal Drink ");
    }

}
