package magazine;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Store {
    private int client = 0;
    ReentrantLock locker;
    Condition condition;

    Store() {
        locker = new ReentrantLock();
        condition = locker.newCondition();
    }

    public void went() {
        locker.lock();
        try {
            while (client == 5) {
                System.out.println("В магазин не принимаем клиентов!");
                condition.await();
            }

        client++;
        System.out.println("Client entered!");
        System.out.println("Magazine has " + client + " clients");
        condition.signalAll();
    }  catch (InterruptedException e) {
        e.printStackTrace();
    } finally {
            locker.unlock();
        }
    }

    public void left() {
        locker.lock();
        try {
            while (client < 4) {
                System.out.println("Магазин уходит на перерыв на 10 секунд!");
                Thread.sleep(10000);
                condition.await();
            }
            Random random = new Random();
            int ran = random.nextInt(9);

            try {
                Thread.sleep(ran * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Магазин работает!");
            client--;
            System.out.println("Client leaves!");
            System.out.println("Magazine has " + client + " clients");
            condition.signalAll();
        }  catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            locker.unlock();
        }
    }
}
