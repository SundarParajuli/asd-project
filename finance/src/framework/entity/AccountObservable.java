package framework.entity;

public interface AccountObservable {
    void registerObserver(AccountObserver observer);
    void removeObserver(AccountObserver observer);
    void notifyObservers(String type);
}
