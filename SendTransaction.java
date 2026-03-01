package model;

public class SendTransaction extends Transaction {

    private String receiver;

    public SendTransaction(double amount, String receiver) {
        super(amount);
        this.receiver = receiver;
        this.description = "Sent Money to " + receiver;
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