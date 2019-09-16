package designPatterns.dp05FactoryPattern2;

public abstract class Car {

    public abstract String type();

    public void  assembleParts(){
        System.out.println("Assembling Car Parts.");
    }
}
