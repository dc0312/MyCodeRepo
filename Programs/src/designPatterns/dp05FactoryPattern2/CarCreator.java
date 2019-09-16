package designPatterns.dp05FactoryPattern2;

public abstract class CarCreator {

    public Car getCar(){
        Car car = getCarType();

        car.assembleParts();

        return car;
    }

    public abstract Car getCarType();


}
