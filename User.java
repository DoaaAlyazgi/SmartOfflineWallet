package model;

public class User {
    

/**
 * يمثل المستخدم الذي يملك محفظة
 */


    private String name;
    private Wallet wallet;

    public User(String name) {
        this.name = name;
        this.wallet = new Wallet();
    }

    public String getName() {
        return name;
    }

    public Wallet getWallet() {
        return wallet;
    }
}
