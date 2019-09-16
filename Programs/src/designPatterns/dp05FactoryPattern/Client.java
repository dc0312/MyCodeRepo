package designPatterns.dp05FactoryPattern;

import java.util.StringTokenizer;

public class Client {

    public static void main(String[] args) {
        printMessage(new JSONMessageCreator());

    }

    private static void printMessage(MessageCreator messageCreator){
        Message msg = messageCreator.getMessage();
        System.out.println(msg);
    }
}
