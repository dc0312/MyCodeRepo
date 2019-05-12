package Programs.src;

public interface D extends A,B {
    @Override
    void test();

    @Override
    default void testDef() {
        A.super.testDef();
    }
}
