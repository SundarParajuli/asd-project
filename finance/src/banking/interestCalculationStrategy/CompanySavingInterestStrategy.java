package banking.interestCalculationStrategy;

import framework.entity.InterestCalculationStrategy;

public class CompanySavingInterestStrategy implements InterestCalculationStrategy {
    @Override
    public double calculateInterest(double balance) {
        return balance * 0.10;
    }
}
