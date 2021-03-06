package designPatterns.dp06AbstractFactoryPattern.aws;

import designPatterns.dp06AbstractFactoryPattern.Instance;
import designPatterns.dp06AbstractFactoryPattern.ResourceFactory;
import designPatterns.dp06AbstractFactoryPattern.Storage;

//Factory implementation for Google cloud platform resources
public class AwsResourceFactory implements ResourceFactory {


    @Override
    public Instance createInstance(Instance.Capacity capacity) {
        return new Ec2Instance(capacity);
    }

    @Override
    public Storage createStorage(int capMib) {
        return new S3Storage(capMib);
    }
}
