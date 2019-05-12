package Programs.com.dc.designPatterns.dp05SingletonPattern;

public class EagerRegistry {

    private EagerRegistry(){

    }

    private static final EagerRegistry INSTANCE = new EagerRegistry();

    public static EagerRegistry getInstance(){
        return INSTANCE;
    }
}
