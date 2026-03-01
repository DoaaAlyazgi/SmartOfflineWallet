# SmartOfflineWallet
Offline-first Java wallet app with secure PIN, full transaction history, and automatic sync
# 💳 Smart Offline Wallet

A Java-based digital wallet system built using Object-Oriented Programming (OOP) principles.  
This project simulates an offline-first wallet that allows users to perform financial transactions and sync them when internet becomes available.

---

## 🚀 Features

- 👤 User creation with initial balance
- 📥 Receive Money
- 📤 Send Money
- 🛠️ Pay for Services
- 📊 Transaction history with:
  - Amount
  - Description
  - Status (SUCCESS / FAILED)
  - Timestamp
- 🌐 Internet availability simulation
- ☁️ Sync transactions when internet is available
- 💾 Save transactions using Serialization
- 🧠 Prevent duplicate transaction processing

---

## 🏗️ Project Structure

```
SmartOfflineWallet
│
├── model
│   ├── Wallet.java
│   ├── Transaction.java
│   ├── ReceiveTransaction.java
│   ├── SendTransaction.java
│   ├── PaymentTransaction.java
│   └── TransactionStatus.java
│
├── service
│   ├── SecurityManager.java
│   ├── NetworkManager.java
│   └── SyncService.java
│
├── util
│   └── FileManager.java
│
└── Main.java
```

---

## 🧠 OOP Concepts Used

- ✅ Encapsulation
- ✅ Inheritance
- ✅ Polymorphism
- ✅ Abstraction
- ✅ Enum
- ✅ Serialization
- ✅ Separation of Concerns

---

## 🛠️ How It Works

1. User enters name and initial balance.
2. User chooses one financial operation.
3. Transaction is processed via polymorphism.
4. System prints a full final report.
5. If internet is available → transactions are saved.
6. If not → system displays sync message.

---

## 📌 Example Output

```
======= FINAL REPORT =======
User Name: Doaa
Initial Balance: 800
Report Time: 2026-02-26T10:17

--- Transactions ---
1. Sent Money to Ahmed | Amount: 300 | Status: SUCCESS

Final Balance: 500
=============================
```

---

## 💡 Future Improvements

- Multiple operations per session
- Persistent wallet loading on startup
- Android UI version
- Real API-based online sync

---

## 👩‍💻 Author

Developed by Doaa Alyazgi  
Computer Engineering Student# 💳 Smart Offline Wallet

