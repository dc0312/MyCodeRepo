package Programs.src.practice2;

public interface Animal1 {

    void eat();

    default void drink(){
        System.out.println("Animal 1 drinks");
    }
}
