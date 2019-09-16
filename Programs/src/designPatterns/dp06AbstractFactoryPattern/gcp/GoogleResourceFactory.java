package designPatterns.dp06AbstractFactoryPattern.gcp;


import designPatterns.dp06AbstractFactoryPattern.Instance;
import designPatterns.dp06AbstractFactoryPattern.ResourceFactory;
import designPatterns.dp06AbstractFactoryPattern.Storage;

//Factory implementation for Google cloud platform resources
public class GoogleResourceFactory implements ResourceFactory {


    @Override
    public Instance createInstance(Instance.Capacity capacity) {
        return new GoogleComputeEngineInstance(capacity);
    }

    @Override
    public Storage createStorage(int capMib) {
        return new GoogleCloudStorage(capMib);
    }
}
