package overLoadingOverRiddingPractice.oops10;

import java.util.HashMap;

public class Overloading {

    static int i;

    public void inst(){
        System.out.println(i);
    }

    public void sum(int a, int b){
        System.out.println("Instance Method Called.");
    }

    public void sum(Integer a, Integer c){
        System.out.println("Wrapper Class.");
    }

    public static void main(String[] args) {
        Overloading overloading = new Overloading();
        overloading.sum(10,2000000000);
        overloading.sum(new Integer(100000), new Integer(2000000000));
        //overloading.sum(10,new Integer(30));

        HashMap hm = new HashMap();
        hm.put("Dc",123);
    }
}
