package model;

public class PaymentTransaction extends Transaction {

    private String serviceName;

    public PaymentTransaction(double amount, String serviceName) {
        super(amount);
        this.serviceName = serviceName;
        this.description = "Payment for " + serviceName;
    }

    @Override
    public void process(Wallet wallet) {
        if (amount <= wallet.getBalance()) {
            wallet.decreaseBalance(amount);
            this.status = TransactionStatus.SUCCESS;
        } else {
            this.status = TransactionStatus.FAILED;
        }
    }
}