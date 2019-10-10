package lambda.statiicc;

interface  Interf{
    static void m1(){
        System.out.println("Interface Static");
    }
}
public class StaticExample1 implements Interf{

    /*public static void m1(){
        System.out.println("Class Static");
    }*/

    /*public void m1(){
        System.out.println("Class Static");
    }*/

    private static void m1(){
        System.out.println("Class Static");
    }

    public static void main(String[] args) {
        //StaticExample1.m1();
        Interf.m1();
    }
}
