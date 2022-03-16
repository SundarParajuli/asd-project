package framework.visitor;

import framework.entity.Account;
import framework.entity.AccountDAO;

public class InterestCalculationVisitor implements AccountVisitor {
    AccountDAO accountDAO;


    public InterestCalculationVisitor(AccountDAO accountDAO){
        this.accountDAO = accountDAO;
    }

    @Override
    public void visit(Account account) {
        account.interest();
        accountDAO.updateAccount(account);
    }
}
