package creditcard.interestCalculatorStrategy;

import framework.entity.InterestCalculationStrategy;

public class GoldInterestStrategy implements InterestCalculationStrategy {
    @Override
    public double calculateInterest(double balance) {
        return 0;
    }
}
