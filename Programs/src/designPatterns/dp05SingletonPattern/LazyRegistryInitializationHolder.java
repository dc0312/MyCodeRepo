package designPatterns.dp05SingletonPattern;

public class LazyRegistryInitializationHolder {

    private LazyRegistryInitializationHolder(){

    }

    private static class RegistryHolder{
        private static final LazyRegistryInitializationHolder INSTANCE = new LazyRegistryInitializationHolder();

    }

    public static LazyRegistryInitializationHolder getInstance(){
        return RegistryHolder.INSTANCE;
    }
}

