package clear.code;

public class Bitcoin implements PaymentProcessing{
    @Override
    public void processPayment(double amount) {
        System.out.println("Оплата Bitcoin на сумму " + amount);
    }
}
