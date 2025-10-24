package complex.task5;

public class Main {
    public static void main(String[] args) {
        Product product1 = new Product("orange", "fruit", 400.99);
        Product product2 = new Product("lemon", "fruit", 350.99);
        Product product3 = new Product("juice", "beverage", 1000.00);
        Product product4 = new Product("coke", "beverage", 800.99);

        InventoryService invService = new InventoryService(false);
        try{
            invService.addProduct(product1);
        } catch (OutOfStockException e){
            System.out.println(e.getMessage());
        }

        invService.setInventoryOpen(true);
        invService.addProduct(product1);
        invService.addProduct(product2);
        invService.addProduct(product3);
        invService.addProduct(product4);

        System.out.println(invService.getProductsByCategory("fruit"));

        System.out.println(invService.filterProducts("beverage", 1000.00, 2000.00));

    }
}
