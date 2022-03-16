package creditcard.paymentCalculationStrategy;

public interface PaymentCalculationStrategy {
    double calculateDuePayment(double balance);
    double calculateBalance(double prevBalance, double totalCredit, double totalCharge);
}
