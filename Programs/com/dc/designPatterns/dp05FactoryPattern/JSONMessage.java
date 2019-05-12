package Programs.com.dc.designPatterns.dp05FactoryPattern;

public class JSONMessage extends  Message {
    @Override
    public String getContent() {
        return "{\"JSON]\":[]}";
    }
}
