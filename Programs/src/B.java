package Programs.src;

public interface B {
    void test();

    default void testDef(){
        System.out.println("Default B");
    }
}
