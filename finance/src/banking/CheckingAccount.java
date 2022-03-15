package banking;


import framework.entity.Account;
import framework.entity.InterestCalculator;
import framework.visitor.AccountVisitor;

public class CheckingAccount extends Account {
    public CheckingAccount(InterestCalculator interestCalculator) {
        super(interestCalculator);
    }

    @Override
    public String getAccountType() {
        return AccountTypes.Checking.name();
    }

    @Override
    public void accept(AccountVisitor accountVisitor) {
        accountVisitor.visit(this);
    }
}
