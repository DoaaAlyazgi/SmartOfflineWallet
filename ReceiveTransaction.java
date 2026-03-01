package model;

public class ReceiveTransaction extends Transaction {

    public ReceiveTransaction(double amount) {
        super(amount);
        this.description = "Received Money";
    }

    @Override
    public void process(Wallet wallet) {
        wallet.increaseBalance(amount);
        this.status = TransactionStatus.SUCCESS;
    }
}