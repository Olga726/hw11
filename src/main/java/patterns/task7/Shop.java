package patterns.task7;

import java.util.List;

public class Shop {
    public static void main(String[] args) {
        Order order = new Order.OrderBuilder()
                .items(List.of("спички", "сигареты"))
                .discount(5.0)
                .paymentMethod("cash")
                .build();

        System.out.println(order);
    }
}
