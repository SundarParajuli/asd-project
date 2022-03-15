package framework.entity;

public interface Observable {
    void registerObserver(AccountObserver observer);
    void removeObserver(AccountObserver observer);
    void notifyObservers();
}
