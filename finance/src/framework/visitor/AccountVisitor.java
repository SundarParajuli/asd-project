package framework.visitor;

import framework.entity.Account;

public interface AccountVisitor {
    void visit(Account account);
}
