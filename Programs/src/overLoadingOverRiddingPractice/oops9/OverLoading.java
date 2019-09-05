package overLoadingOverRiddingPractice.oops9;

public class OverLoading {
    
    public void test(int... x) {
        System.out.println("Var Arg Called");
    }
    
    public void test(int x) {
        System.out.println("Normal method called");
    }
    
    public static void main(String[] args) {
        OverLoading loading = new OverLoading();
        loading.test(1);
    }

}
