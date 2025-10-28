package clear.code;

public class PaymentProcessor {
    private PaymentProcessing paymentProcessing;

    public PaymentProcessor(PaymentProcessing paymentProcessing) {
        this.paymentProcessing = paymentProcessing;
    }

    public void makePayment(double amount){
        paymentProcessing.processPayment(amount);
    }

    /*
    public void processPayment(String paymentType, double amount) {
        if (paymentType.equals("CreditCard")) {
            System.out.println("Оплата кредитной картой на сумму " + amount);
        } else if (paymentType.equals("PayPal")) {
            System.out.println("Оплата через PayPal на сумму " + amount);
        } else if (paymentType.equals("Bitcoin")) {
            System.out.println("Оплата Bitcoin на сумму " + amount);
        }
    }*/
}
