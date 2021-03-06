package creditcard.interestCalculatorStrategy;

import framework.entity.InterestCalculationStrategy;

public class BronzeInterestStrategy implements InterestCalculationStrategy {
    @Override
    public double calculateInterest(double balance) {
        return balance * 0.1;
    }
}
