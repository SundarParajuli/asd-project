package framework;


import framework.ui.MainFrm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AccountService implements Observable {
    private AccountDAO accountDAO;
    private List<Observer> observerList;
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
        this.operation = AccountOperation.CREATED;
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
        this.operation = AccountOperation.DEPOSITED;
        notifyObservers();
    }

    public void withdraw(String accountNumber, double amount) {
        Account account = accountDAO.loadAccount(accountNumber);
        account.withdraw(amount);
        accountDAO.updateAccount(account);
        this.changedAccount = account;
        this.changedAmount = amount;
        this.operation = AccountOperation.WITHDREW;
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
    public void registerObserver(Observer observer) {
        this.observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        this.observerList.forEach(Observer::update);
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
