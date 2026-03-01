package model;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public abstract class Transaction implements Serializable {

    protected double amount;
    protected String description;
    protected long timeMillis; // لتجنب مشاكل Serializable مع LocalDateTime
    protected TransactionStatus status;
    protected boolean processed = false; // لتجنب تكرار العملية

    public Transaction(double amount) {
        this.amount = amount;
        this.timeMillis = System.currentTimeMillis(); // حفظ الوقت كـ long
        this.status = TransactionStatus.FAILED;
        this.description = "";
    }

    // تنفيذ العملية على Wallet
    public abstract void process(Wallet wallet);

    // Getters
    public double getAmount() { return amount; }
    public String getDescription() { return description; }

    public LocalDateTime getTime() {
        return Instant.ofEpochMilli(timeMillis)
                      .atZone(ZoneId.systemDefault())
                      .toLocalDateTime();
    }

    public TransactionStatus getStatus() { return status; }
    public boolean isProcessed() { return processed; }
    public void setProcessed(boolean processed) { this.processed = processed; }
}