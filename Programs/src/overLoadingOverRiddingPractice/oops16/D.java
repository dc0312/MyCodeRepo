package overLoadingOverRiddingPractice.oops16;

interface A{
    default void hello(){
        System.out.println("Hello From A");
    }
    /*static void hello(){
        System.out.println("Static");
    }*/
}

interface B extends A {
    default void hello(){
        System.out.println("Hello From B");
    }
}

interface C extends A {
    default void hello(){
        System.out.println("Hello From C");
    }
}

public class D implements B, C {

    public static void main(String[] args) {
        new D().hello(); //what will happen here
    }

    @Override
    public void hello() {
        C.super.hello();
    }
}
