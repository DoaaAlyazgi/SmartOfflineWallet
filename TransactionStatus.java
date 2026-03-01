package model;

/**
 * يمثل حالة أي عملية في المحفظة
 */
public enum TransactionStatus {
    SUCCESS,   // العملية تمت بنجاح
    FAILED     // العملية فشلت (مثل عدم كفاية الرصيد)
}