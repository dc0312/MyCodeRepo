package designPatterns.dp05FactoryPattern2;

public class ClientCar {
    public static void main(String[] args) {
        makeCar(new SmallCarCreator());
        makeCar(new LuxuryCarCreator());
    }

    private static void makeCar(CarCreator carCreator){
        Car car = carCreator.getCar();
        System.out.println(car.type());
    }
}
