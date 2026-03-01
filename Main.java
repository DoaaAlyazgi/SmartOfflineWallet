import model.*;
import service.*;
import util.FileManager;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("==== SMART OFFLINE WALLET ====");

        // إدخال اسم المستخدم
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        User user = new User(name);
        Wallet wallet = user.getWallet();

        // إدخال الرصيد الابتدائي
        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();
        wallet.increaseBalance(initialBalance);

        // حالة النت
        System.out.print("Is internet available? (yes/no): ");
        scanner.nextLine();
        String netInput = scanner.nextLine().trim();
        boolean hasInternet = netInput.equalsIgnoreCase("yes");

        System.out.println("\nChoose ONE operation:");
        System.out.println("1. Receive Money");
        System.out.println("2. Send Money");
        System.out.println("3. Pay for Service");
        System.out.print("Your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {

            case 1:
                System.out.print("Enter amount to receive: ");
                double receiveAmount = scanner.nextDouble();
                wallet.addTransaction(new ReceiveTransaction(receiveAmount));
                break;

            case 2:
                System.out.print("Enter amount to send: ");
                double sendAmount = scanner.nextDouble();
                if (sendAmount > wallet.getBalance()) {
                    System.out.println("❌ ERROR: Insufficient funds. Operation cancelled.");
                    scanner.close();
                    return;
                }
                scanner.nextLine();
                System.out.print("Enter receiver name: ");
                String receiver = scanner.nextLine();
                wallet.addTransaction(new SendTransaction(sendAmount, receiver));
                break;

            case 3:
                System.out.print("Enter payment amount: ");
                double paymentAmount = scanner.nextDouble();
                if (paymentAmount > wallet.getBalance()) {
                    System.out.println("❌ ERROR: Insufficient funds. Operation cancelled.");
                    scanner.close();
                    return;
                }
                scanner.nextLine();
                System.out.print("Enter service name: ");
                String serviceName = scanner.nextLine();
                wallet.addTransaction(new PaymentTransaction(paymentAmount, serviceName));
                break;

            default:
                System.out.println("Invalid choice.");
                scanner.close();
                return;
        }

        // عرض التقرير النهائي
        wallet.printFullSummary(name, initialBalance);

        // المزامنة مع النت
        if (hasInternet) {
            FileManager fm = new FileManager();
            fm.saveTransactions("transactions.dat", wallet.getTransactions());
        } else {
            System.out.println("⚠️ Internet not available. Transactions will sync later.");
        }

        scanner.close();
    }
}