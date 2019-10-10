package lambda.anonymousVsLambda;

interface Intref{
    public void m1();
}
class AnonymousTest {

    int x = 888;

    public void m2(){
        Intref i = new Intref() {
            int x = 999;//This is an instance variable
            @Override
            public void m1() {
                System.out.println(this.x);//here this will call the inner class x not the AnonymousTest class x.
            }
        };

        i.m1();
    }

    public static void main(String[] args) {
        AnonymousTest test1 = new AnonymousTest();
        test1.m2();
    }
}
