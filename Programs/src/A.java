package Programs.src;

public interface A {
    void test();

    default void testDef(){
        System.out.println("Default A");
    }
}
