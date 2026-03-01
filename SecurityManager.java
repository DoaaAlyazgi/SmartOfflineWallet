package service;

public class SecurityManager {
    private String pin; //، سيتم تعيينه بواسطة المستخدم

    // دالة لتعيين PIN
    public void setPin(String newPin) {
        this.pin = newPin;
    }

    // دالة للتحقق من صحة PIN عند الدخول
    public boolean validatePin(String input) {
        return pin != null && pin.equals(input);
    }
}