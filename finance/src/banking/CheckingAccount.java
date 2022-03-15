package banking;


import framework.entity.Account;
import framework.entity.InterestCalculationStrategy;

import framework.visitor.AccountVisitor;

public class CheckingAccount extends Account {
    public CheckingAccount(InterestCalculationStrategy interestCalculationStrategy) {
        super(interestCalculationStrategy);
    }

    @Override
    public String getAccountType() {
        return AccountType.CHECKING.name();
    }

    @Override
    public void accept(AccountVisitor accountVisitor) {
        accountVisitor.visit(this);
    }
}
