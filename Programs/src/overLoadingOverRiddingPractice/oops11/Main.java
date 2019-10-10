package overLoadingOverRiddingPractice.oops11;
@FunctionalInterface
interface Parent{
    public void m1();
}
@FunctionalInterface
interface Child extends Parent{

}
public class Main {
    public static void main(String[] args) {
        Child c = () -> System.out.println("Lambda Interface");
        c.m1();
    }
}
