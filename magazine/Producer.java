package magazine;

public class Producer extends Thread{
    Store store;

    public Producer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        for (int i = 1; i < 10; i++) {
            store.went();
        }
    }
}
