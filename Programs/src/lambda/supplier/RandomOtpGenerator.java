package lambda.supplier;

import java.util.function.Supplier;

public class RandomOtpGenerator {
    public static void main(String[] args) {
        Supplier<String> s = () ->{

            StringBuilder otp = new StringBuilder(6);
            for(int i =0; i< 6;i++){
                otp.append((int) (Math.random()*10));
            }
            return otp.toString();
        };

        System.out.println(s.get());
    }
}
