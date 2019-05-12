package Programs.src;

public class C implements A,B {
    @Override
    public void test() {

    }

    @Override
    public void testDef() {
        A.super.testDef();
    }

    public static void main(String[] args) {
        C c = new C();
        c.test();
        c.testDef();

        Boolean x = new Boolean("true");
        Boolean y = new Boolean("true");
        System.out.println(x.equals(y));

    }
}
