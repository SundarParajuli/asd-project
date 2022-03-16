package framework.entity;


import java.util.List;

public interface AccountDAO {
    void saveAccount(Account account);
    void updateAccount(Account account);
    Account loadAccount(String accountNumber);
    List<Account> getAccounts();
}
