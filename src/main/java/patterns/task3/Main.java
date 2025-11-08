package patterns.task3;

public class Main {
    public static void main(String[] args) {
        TransportFactory factory;
        factory = new CarFactory();
        factory.done();

        factory = new BicycleFactory();
        factory.done();
    }
}
