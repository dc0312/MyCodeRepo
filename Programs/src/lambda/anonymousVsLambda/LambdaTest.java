package lambda.anonymousVsLambda;
interface Interf{
    public void m1();
}
public class LambdaTest {

    int x = 888;

    public void m2(){
        Intref i = () -> {
            int x = 999;//This a local variable
            System.out.println(this.x);//here this will refer to class level variable not the lambda expression x.
        };

        i.m1();
    }

    public static void main(String[] args) {
        LambdaTest lambdaTest = new LambdaTest();
        lambdaTest.m2();
    }
}
