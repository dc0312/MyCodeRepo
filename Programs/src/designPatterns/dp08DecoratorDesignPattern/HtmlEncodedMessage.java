package designPatterns.dp08DecoratorDesignPattern;


//Decorator. Implements component interface
public class HtmlEncodedMessage implements Message{

    private Message message;

    public HtmlEncodedMessage(Message message){
        this.message = message;
    }

    @Override
    public String getContent() {
        return message.getContent();
    }
}
