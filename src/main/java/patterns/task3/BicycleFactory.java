package patterns.task3;

public class BicycleFactory extends TransportFactory{
    @Override
    public Transport createTransport() {
        return new Bicycle();
    }
}
