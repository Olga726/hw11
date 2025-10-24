package complex.task5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InventoryService {
    private boolean isInventoryOpen;

    public InventoryService(boolean isInventoryOpen) {
        this.isInventoryOpen = isInventoryOpen;
    }

    public void setInventoryOpen(boolean inventoryOpen) {
        isInventoryOpen = inventoryOpen;
    }

    public boolean isInventoryOpen() {
        return isInventoryOpen;
    }

    private Map<String, List<Product>> map = new HashMap<>();

    public void addProduct(Product product){
        if(!isInventoryOpen){
            throw new OutOfStockException("Операции с товарами запрещены");
        } else if(product ==null){
            throw new OutOfStockException("Товар не может быть null");
        } else if(product.getPrice()<0){
            throw new OutOfStockException("Цена не может быть отрицательной");
        }
        map.putIfAbsent(product.getCategory(), new ArrayList<>());
        map.get(product.getCategory()).add(product);
    }

    public Product getProductsByCategory(String category){
        if(category==null){
            throw new OutOfStockException("Категория не может быть null");
        } else if(!map.containsKey(category) || map.isEmpty() || map.get(category).isEmpty()){
            throw new OutOfStockException("Категория отсутствует");
        }
        List<Product> products = map.get(category);
        return products.remove(0);
    }

    public List<Product> showProductsByCategory(String category){
        return map.get(category);
    }

    public List<Product> filterProducts(String category, double priceFrom, double priceTo){
        if(priceFrom>priceTo){
            throw new OutOfStockException("Неверный диапазон цен");
        }
        return map.entrySet().stream()
                .filter(entry ->entry.getKey().equalsIgnoreCase(category))
                .flatMap(entry -> entry.getValue().stream())
                .filter(p -> p.getPrice()>=priceFrom && p.getPrice()<=priceTo)
                .collect(Collectors.toList());
    }


}
