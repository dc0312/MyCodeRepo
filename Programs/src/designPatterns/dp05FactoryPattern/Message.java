package designPatterns.dp05FactoryPattern;

public abstract class Message {

    public abstract String getContent();

    public void addDefaultHeaders(){

    };

    public void encrypt(){

    }
}
