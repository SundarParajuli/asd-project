package banking;


import framework.entity.Account;
import framework.entity.InterestCalculationStrategy;

public class CheckingAccount extends Account {
    public CheckingAccount(InterestCalculationStrategy interestCalculationStrategy) {
        super(interestCalculationStrategy);
    }

    @Override
    public String getAccountType() {
        return AccountType.CHECKING.name();
    }
}
