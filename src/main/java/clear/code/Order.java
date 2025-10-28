package clear.code;

public class Order {
    private OrderProcess orderProcess = new OrderProcess();
    private EmailConfirmation emailConfirmation = new EmailConfirmation();
    private InvoiceGenerator invoiceGenerator = new InvoiceGenerator();

    public void manageOrder() {
        orderProcess.processOrder();
        emailConfirmation.sendEmailConfirmation();
        invoiceGenerator.generateInvoice();
    }
}
