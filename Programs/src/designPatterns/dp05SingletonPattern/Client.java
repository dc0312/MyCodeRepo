package designPatterns.dp05SingletonPattern;

public class Client {

    public static void main(String[] args) {
        EagerRegistry eagerRegistry1 = EagerRegistry.getInstance();
        EagerRegistry eagerRegistry2 = EagerRegistry.getInstance();

        System.out.println(eagerRegistry1==eagerRegistry2);

        LazyRegistryDCL lazyRegistryDCL1 =LazyRegistryDCL.getInstance();
        LazyRegistryDCL lazyRegistryDCL2 =LazyRegistryDCL.getInstance();

        System.out.println(lazyRegistryDCL1==lazyRegistryDCL2);

        LazyRegistryInitializationHolder holder1 = LazyRegistryInitializationHolder.getInstance();
        LazyRegistryInitializationHolder holder2 = LazyRegistryInitializationHolder.getInstance();

        System.out.println(holder1 == holder2);

        SingletonEnum singletonEnum1 = SingletonEnum.SINGLETON_ENUM;
        SingletonEnum singletonEnum2 = SingletonEnum.SINGLETON_ENUM;

        System.out.println(singletonEnum1==singletonEnum2);
    }
}