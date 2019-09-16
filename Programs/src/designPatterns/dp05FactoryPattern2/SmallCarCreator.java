package designPatterns.dp05FactoryPattern2;

public class SmallCarCreator extends CarCreator {
    @Override
    public Car getCarType() {
        return new SmallCar();
    }
}
