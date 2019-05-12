package Programs.com.dc.designPatterns.dp05FactoryPattern;

public class JSONMessageCreator extends MessageCreator {
    @Override
    public Message createMessage() {
        return new JSONMessage();
    }
}
