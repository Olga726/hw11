package patterns.task5;

public class MakeOrder {
    private Chair chair;
    private Table table;

    public MakeOrder(FurnitureFactory factory) {
        chair = factory.createChair();
        table = factory.createTable();
    }

    public void done() {
        table.use();
        chair.sitOn();
    }
}
