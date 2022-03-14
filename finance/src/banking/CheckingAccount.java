package banking;


import framework.Account;
import framework.InterestCalculator;

public class CheckingAccount extends Account {
    public CheckingAccount(InterestCalculator interestCalculator) {
        super(interestCalculator);
    }

    @Override
    public String getAccountType() {
        return AccountTypes.Checking.name();
    }
}
