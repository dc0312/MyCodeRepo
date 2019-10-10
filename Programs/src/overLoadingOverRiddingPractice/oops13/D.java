package overLoadingOverRiddingPractice.oops13;

interface A{
    default void hello(){
        System.out.println("Hello From A");
    }
}

interface B extends A{}

interface C extends A{}
public class D implements B,C {

    public static void main(String[] args) {
        //new D().hello(); what will happen here
    }
}
