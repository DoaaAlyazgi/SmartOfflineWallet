package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Wallet implements Serializable {

    private double balance;
    private List<Transaction> transactions;

    public Wallet() {
        balance = 0;
        transactions = new ArrayList<>();
    }

    public void increaseBalance(double amount) {
        balance += amount;
    }

    public void decreaseBalance(double amount) {
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void addTransaction(Transaction transaction) {
        if (!transaction.isProcessed()) {
            transaction.process(this);
            transaction.setProcessed(true);
            transactions.add(transaction);
        }
    }

    public void printTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("📭 No transactions yet.");
            return;
        }

        for (int i = 0; i < transactions.size(); i++) {
            Transaction t = transactions.get(i);
            System.out.println((i + 1) + ". " + t.getDescription() +
                    " | Amount: " + t.getAmount() +
                    " | Time: " + t.getTime() +
                    " | Status: " + t.getStatus());
        }
    }

    public void printFullSummary(String userName, double initialBalance) {
        System.out.println("\n======= FINAL REPORT =======");
        System.out.println("User Name: " + userName);
        System.out.println("Initial Balance: " + initialBalance);
        System.out.println("Report Time: " + java.time.LocalDateTime.now());
        System.out.println("\n--- Transactions ---");
        printTransactions();
        System.out.println("\nFinal Balance: " + getBalance());
        System.out.println("=============================");
    }
}