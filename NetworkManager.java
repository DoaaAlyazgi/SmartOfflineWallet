package service;

public class NetworkManager {

/**
 * يمثل حالة الاتصال بالانترنت
 */


    private boolean online = false;

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean status) {
        online = status;
    }
}
