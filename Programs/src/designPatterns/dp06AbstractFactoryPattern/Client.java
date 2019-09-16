package designPatterns.dp06AbstractFactoryPattern;


import designPatterns.dp06AbstractFactoryPattern.aws.AwsResourceFactory;

public class Client {

    private ResourceFactory resourceFactory;

    Client(ResourceFactory resourceFactory){
        this.resourceFactory = resourceFactory;
    }

    private Instance createInstance(Instance.Capacity capacity, int capMib){
        Instance instance = resourceFactory.createInstance(capacity);
        Storage storage = resourceFactory.createStorage(capMib);
        instance.attachStorage(storage);
        return instance;
    }

    public static void main(String[] args) {

        Client client = new Client(new AwsResourceFactory());

        Instance i1 = client.createInstance(Instance.Capacity.micro,2048);
        i1.start();
        i1.stop();
    	
    }

}
