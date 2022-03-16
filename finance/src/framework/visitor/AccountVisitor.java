package framework.visitor;

import banking.CheckingAccount;
import banking.SavingAccount;
import creditcard.CreditAccount;

public interface AccountVisitor {
    void visit(CheckingAccount account);

    void visit(SavingAccount account);

    void visit(CreditAccount account);
}
