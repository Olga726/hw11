package clear.code;

public class CreditCard implements PaymentProcessing{
    @Override
    public void processPayment(double amount) {
        System.out.println("Оплата кредитной картой на сумму " + amount);
    }
}
