package creditcard.interestCalculatorStrategy;

import framework.entity.InterestCalculationStrategy;

public class SilverInterestStrategy implements InterestCalculationStrategy {
    @Override
    public double calculateInterest(double balance) {
        return balance * 0.08;
    }
}
