package creditcard.paymentCalculators;

public class BronzePaymentCalculator implements PaymentCalculator{
    @Override
    public double calculateDuePayment(double balance) {
        return balance * 0.14;
    }

    @Override
    public double calculateBalance(double prevBalance, double totalCredit, double totalCharge) {
        return prevBalance - totalCredit + totalCharge + 0.1 * (prevBalance - totalCredit);
    }
}
