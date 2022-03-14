package framework;

public interface AccountObservable {
    void registerObserver(AccountObserver accountObserver);
    void removeObserver(AccountObserver accountObserver);
    void notifyObservers();
}
