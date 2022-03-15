package framework.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import framework.ui.MainFrm;

public abstract class AccountService implements AccountObservable {
    private AccountDAO accountDAO;
    private List<AccountObserver> observerList;
    private Account changedAccount;
    private double changedAmount;
    protected AccountOperation operation;
    private String report;

    public AccountService(AccountDAO accountDAO){
        this.accountDAO = accountDAO;
        this.observerList = new ArrayList<>();
        this.registerObserver(MainFrm.getInstance());
        MainFrm.getInstance().setSubject(this);
    }

    public final void createAccount(String accountNumber, Customer customer, String accountType) {
        Account account = this.initAccount(accountType, customer);
        account.setCustomer(customer);
        account.setAccountNumber(accountNumber);
        accountDAO.saveAccount(account);
        this.changedAccount = account;
        this.operation = AccountOperation.CREATE;
        notifyObservers();
    }

    public abstract Account initAccount(String accountType, Customer customer);

    public void deposit(String accountNumber, double amount) {
        Account account = accountDAO.loadAccount(accountNumber);
        if(account != null) {
            account.deposit(amount);
            accountDAO.updateAccount(account);
        }else{
            System.out.println("deposited");
        }
        this.changedAccount = account;
        this.changedAmount = amount;
        this.operation = AccountOperation.DEPOSIT;
        notifyObservers();
    }

    public void withdraw(String accountNumber, double amount) {
        Account account = accountDAO.loadAccount(accountNumber);
        account.withdraw(amount);
        accountDAO.updateAccount(account);
        this.changedAccount = account;
        this.changedAmount = amount;
        this.operation = AccountOperation.WITHDRAW;
        notifyObservers();
    }

    public void addInterest() {
        Collection<String> actNums = getAllAccounts().stream().map(Account::getAccountNumber).collect(Collectors.toList());
        for (String actNum : actNums) {
            Account account = accountDAO.loadAccount(actNum);
            account.interest();
            accountDAO.updateAccount(account);
        }
        this.operation = AccountOperation.INTEREST;
        notifyObservers();
    }

    public void buildReport() {
    }

    @Override
    public void registerObserver(AccountObserver observer) {
        this.observerList.add(observer);
    }

    @Override
    public void removeObserver(AccountObserver observer) {
        this.observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        this.observerList.forEach(AccountObserver::update);
    }

    public Account getAccount(String accountNumber) {
        return accountDAO.loadAccount(accountNumber);
    }

    public Collection<Account> getAllAccounts() {
        return accountDAO.getAccounts();
    }

    public Account getChangedAccount() {
        return changedAccount;
    }

    public AccountOperation getOperation() {
        return operation;
    }

    public double getChangedAmount() {
        return changedAmount;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }
}
