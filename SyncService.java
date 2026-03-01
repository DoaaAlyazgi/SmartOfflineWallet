package service;

import model.Transaction;
import java.util.List;

public class SyncService {
    public void sync(List<Transaction> transactions) {
        if (transactions.isEmpty()) {
            System.out.println("No pending transactions to sync.");
            return;
        }
        System.out.println("Syncing " + transactions.size() + " transactions...");
        // هنا ممكن إضافة منطق فعلي للمزامنة مع السيرفر
    }
}