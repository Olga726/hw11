package clear.code;

public class PayPal implements PaymentProcessing{
    @Override
    public void processPayment(double amount) {
        System.out.println("Оплата через PayPal на сумму " + amount);
    }
}
