package designPatterns.dp05FactoryPattern;

public abstract class MessageCreator {

    public Message getMessage(){
        //here we call the factory method
        Message msg = createMessage();
        //here we will do some operations on the object that we will get from factory method.
        msg.addDefaultHeaders();
        msg.encrypt();

        return msg;
    }

    //Factory method
    public abstract  Message createMessage();
}
