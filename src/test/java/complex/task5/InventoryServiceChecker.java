package complex.task5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class InventoryServiceChecker {
    private InventoryService inventoryService;
    private Product product1;
    private Product product2;
    private Product product3;
    private Product product4;
    private Product product5;
    private Product product6;
    private Product product7;

    @BeforeEach
    void setUp(){
        inventoryService = new InventoryService(true);
        product1 = new Product("orange", "fruit", 400.99);
        product2 = new Product("orange", "fruit", 400.99);
        product3 = new Product("lemon", "fruit", 400.98);
        product6 = new Product("lemon", "fruit", 401.00);
        product4 = new Product("juice", "beverage", 400.99);
        product5 = new Product("water", "beverage", 0.00);
        product7 = new Product("nothing", "beverage", -0.01);
    }

    @Test
    public void checkAddProductWithValidItems(){
        inventoryService.addProduct(product1);
        assertEquals(1, inventoryService.showProductsByCategory(product1.getCategory()).size());

        assertEquals(product1, product2);  //equals переопределен

        inventoryService.addProduct(product2);
        assertEquals(2, inventoryService.showProductsByCategory(product1.getCategory()).size()); //добавление одинаковых Product
    }

    @Test
    public void checkAddProductUnavailableWithInventoryServiceOff(){
        inventoryService.setInventoryOpen(false);
        assertThrows(OutOfStockException.class, ()->inventoryService.addProduct(product1));
    }

    @Test
    public void checkUserCanNotAddNullProduct(){
        assertThrows(OutOfStockException.class, ()->inventoryService.addProduct(null));
    }

    @Test
    public void checkUserCanNotAddNegativePriceProduct(){
        assertThrows(OutOfStockException.class, ()->inventoryService.addProduct(product7));
    }

    @Test
    public void checkGetProductsByCategory(){
        inventoryService.addProduct(product1);
        assertEquals(product1, inventoryService.getProductsByCategory(product1.getCategory()));
        assertTrue(inventoryService.showProductsByCategory(product1.getCategory()).isEmpty());
    }

    @Test
    public void checkUserCanNotGetProductsByInvalidCategory(){
        assertThrows(OutOfStockException.class, ()->inventoryService.getProductsByCategory("falseCategory")); //проверка при пустом Map

        inventoryService.addProduct(product1);
        assertThrows(OutOfStockException.class, ()->inventoryService.getProductsByCategory("falseCategory")); //категории нет в Map

        inventoryService.getProductsByCategory(product1.getCategory());
        assertThrows(OutOfStockException.class, ()-> inventoryService.getProductsByCategory(product1.getCategory()));  //в категории нет продуктов
    }

    @Test
    public void checkFilter(){
        inventoryService.addProduct(product1);
        inventoryService.addProduct(product2);
        inventoryService.addProduct(product3);
        inventoryService.addProduct(product4);
        inventoryService.addProduct(product5);
        inventoryService.addProduct(product6);

        List<Product> filteredList1 = inventoryService.filterProducts(product1.getCategory(), product1.getPrice(), product1.getPrice());
        assertEquals(2, filteredList1.size());
        assertTrue(filteredList1.contains(product1) && filteredList1.contains(product2));  //цена от и до - одно значение

        List<Product> filteredList2 = inventoryService.filterProducts(product1.getCategory(), 0.00, 1.00);
        assertTrue(filteredList2.isEmpty());   //нет подходящих Product

    }

    @Test
    public void checkFilterWithInvalidPriceRange(){
        inventoryService.addProduct(product1);
        assertThrows(OutOfStockException.class, ()-> inventoryService.filterProducts(product1.getCategory(), 100, 0.00));
    }


}
