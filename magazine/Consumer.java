package magazine;

public class Consumer extends Thread{
    Store store;

    public Consumer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        for (int i = 1; i < 10; i++) {
            store.left();
        }
    }
}
