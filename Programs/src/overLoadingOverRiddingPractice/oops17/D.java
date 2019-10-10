package overLoadingOverRiddingPractice.oops17;

interface A{
    static void hello(){
        System.out.println("Hello From A");
    }
}

interface B extends A {
    static void hello(){
        System.out.println("Hello From B");
    }
}

interface C extends A {
    static void hello(){
        System.out.println("Hello From C");
    }
}

public class D implements B, C {

    /*public static void main(String[] args) {
        new D().hello(); //what will happen here
    }
*/
    /*@Override
    public void hello() {
        C.super.hello();
    }*/
}
