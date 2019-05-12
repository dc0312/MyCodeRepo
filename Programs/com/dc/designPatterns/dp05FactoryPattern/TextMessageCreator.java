package Programs.com.dc.designPatterns.dp05FactoryPattern;

public class TextMessageCreator extends MessageCreator {
    @Override
    public Message createMessage() {
        return new TextMessage();
    }
}
