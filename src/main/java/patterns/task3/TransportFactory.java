package patterns.task3;

public abstract class TransportFactory {
    public abstract Transport createTransport();

    public void done(){
        Transport transport = createTransport();
        transport.create();
    }
}
