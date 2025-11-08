package patterns.task7;

import java.util.List;

public class Order {
    private List<String> items;
    private double discount;
    private String paymentMethod;

    private Order(OrderBuilder orderBuilder) {
        this.paymentMethod = orderBuilder.paymentMethod;
        this.items = orderBuilder.items;
        this.discount = orderBuilder.discount;
    }

    public static class OrderBuilder {
        private List<String> items;
        private double discount;
        private String paymentMethod;

        public OrderBuilder items(List<String> items) {
            this.items = items;
            return this;
        }

        public OrderBuilder discount(double discount) {
            this.discount = discount;
            return this;
        }

        public OrderBuilder paymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }

    @Override
    public String toString() {
        return "Order{" +
                "items=" + items +
                ", discount=" + discount +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }
}
