package lambda.statiicc;

import overLoadingOverRiddingPractice.Main1;

interface Intef1{
    static void test(){
        System.out.println("Static Inteface");
    }
}
public class StaticExample implements Intef1{

    /*static  int i =10;
    static void test(){
        System.out.println("static");
    }*/
    public static void main(String[] args) {
        Main1 m = new Main1();
        //System.out.println(m.i);
        //m.test();
        //Intef1.test();
    }

}
