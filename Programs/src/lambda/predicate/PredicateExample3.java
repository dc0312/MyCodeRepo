package lambda.predicate;

import java.util.Scanner;
import java.util.function.Predicate;

class User{
    String name;
    String pwd;

    public User(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }
}
public class PredicateExample3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter user name");
        String username = sc.next();
        System.out.println("enter Password");
        String pwd = sc.next();
        User userCred = new User(username,pwd);
        Predicate<User> cond = user -> user.name.equals("Deepak") && user.pwd.equals("DC");

        if(cond.test(userCred)){
            System.out.println("login Success");
        }else{
            System.out.println("please try again");
        }
    }
}
