package Programs.com.dc.designPatterns.dp05FactoryPattern;

public abstract class MessageCreator {

    public Message getMessage(){
        Message msg = createMessage();
        msg.addDefaultHeaders();
        msg.encrypt();

        return msg;
    }

    //Factory method
    public abstract  Message createMessage();
}
