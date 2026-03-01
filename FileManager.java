package util;

import model.Transaction;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class FileManager {

    public void saveTransactions(String filename, List<Transaction> transactions) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(transactions);
            System.out.println("Transactions synced successfully!");
        } catch (IOException e) {
            System.out.println("❌ Error saving transactions: " + e.getMessage());
        }
    }
}