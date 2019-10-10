package overLoadingOverRiddingPractice.oops18;

class C{
     A test(){
         return new A();
     }
}

class D extends C{

     /*B test(){
        return new A();
    }
    B test(){
        return new B();
    }
    A test(){
        return new B();
    }*/
}

class A{

}

class B extends A{

}
public class Main {
    public static void main(String[] args) {
        D d = new D();
        A a = d.test();
    }
}
