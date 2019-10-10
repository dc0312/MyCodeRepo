package overLoadingOverRiddingPractice.oops12;

@FunctionalInterface
interface Parent{
    public void m1(int num);
}

//This is not a functional interface as there will be two methods m1(int) and m1(Integer)
//@FunctionalInterface
/*interface Child extends Parent{
    public void m1(Integer num);
}*/

//If we give the same m1() method structure in Chlid interface then also it will be FunctionalInterface.
@FunctionalInterface
interface Child extends Parent{
    public void m1(int num);
}
public class Main {

    public static void main(String[] args) {
        Child c = (num) -> System.out.println(num);
        c.m1(10);
    }
}

