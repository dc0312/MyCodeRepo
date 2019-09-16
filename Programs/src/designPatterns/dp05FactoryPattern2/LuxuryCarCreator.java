package designPatterns.dp05FactoryPattern2;

public class LuxuryCarCreator extends CarCreator {
    @Override
    public Car getCarType() {
        return new LuxuryCar();
    }
}
