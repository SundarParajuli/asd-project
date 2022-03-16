package creditcard.paymentCalculationStrategy;

public class SilverPaymentCalculationStrategy implements PaymentCalculationStrategy {
    @Override
    public double calculateDuePayment(double balance) {
        return balance * 0.14;
    }

    @Override
    public double calculateBalance(double prevBalance, double totalCredit, double totalCharge) {
        return prevBalance - totalCredit + totalCharge + 0.08 * (prevBalance - totalCredit);
    }
}
