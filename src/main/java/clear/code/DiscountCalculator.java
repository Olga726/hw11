package clear.code;

public class DiscountCalculator {
    public double calculateDiscount(double price, boolean isLoyalCustomer, boolean isFirstPurchase, boolean hasCoupon) {
        double discount = (isLoyalCustomer
                ? (isFirstPurchase ? price * 0.10 : price * 0.05)
                : (hasCoupon ? price * 0.07 : price * 0.02)
        );
        return price - discount;
    }

    public static void main(String[] args) {
        DiscountCalculator calculator = new DiscountCalculator();
        System.out.println(calculator.calculateDiscount(100.00, true, true, true)); //90
        System.out.println(calculator.calculateDiscount(100.00, true, false, true)); //95
        System.out.println(calculator.calculateDiscount(100.00, false, false, true)); //93
        System.out.println(calculator.calculateDiscount(100.00, false, false, false)); //98
    }
}
