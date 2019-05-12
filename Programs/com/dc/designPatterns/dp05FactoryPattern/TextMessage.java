package Programs.com.dc.designPatterns.dp05FactoryPattern;

public class TextMessage extends Message {
    @Override
    public String getContent() {
        return "Text";
    }
}
