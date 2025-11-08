package patterns.task5;

public class Main {
    public static void main(String[] args) {
        FurnitureFactory furnitureFactory;
        furnitureFactory = new ClassicFurnitureFactory();
        MakeOrder order = new MakeOrder(furnitureFactory);
        order.done();
        furnitureFactory = new ModernFurnitureFactory();
        MakeOrder order2 = new MakeOrder(furnitureFactory);
        order2.done();
    }
}
