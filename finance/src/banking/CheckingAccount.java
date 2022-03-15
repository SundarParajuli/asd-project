package banking;


import framework.entity.Account;
import framework.entity.InterestCalculator;

public class CheckingAccount extends Account {
    public CheckingAccount(InterestCalculator interestCalculator) {
        super(interestCalculator);
    }

    @Override
    public String getAccountType() {
        return AccountTypes.Checking.name();
    }
}
