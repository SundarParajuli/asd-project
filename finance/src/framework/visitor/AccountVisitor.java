package framework.visitor;

import banking.CheckingAccount;
import banking.SavingAccount;
import creditcard.CreditAccount;

public interface AccountVisitor {
    void visit(CheckingAccount checkingAccount);
    void visit(SavingAccount checkingAccount);
    void visit(CreditAccount checkingAccount);
}
