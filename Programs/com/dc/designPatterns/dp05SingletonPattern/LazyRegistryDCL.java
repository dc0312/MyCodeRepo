package Programs.com.dc.designPatterns.dp05SingletonPattern;

import Programs.com.dc.designPatterns.dp06AbstractFactoryPattern.Instance;

public class LazyRegistryDCL {

    private LazyRegistryDCL(){

    }

    private static LazyRegistryDCL INSTANCE;

    public static LazyRegistryDCL getInstance(){
        if(INSTANCE==null){
            synchronized (LazyRegistryDCL.class){
                if(INSTANCE==null){
                    INSTANCE = new LazyRegistryDCL();
                }
            }
        }
        return  INSTANCE;
    }
}
