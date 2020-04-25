package l1117;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/25
 */
class H2O {

    private Semaphore h;

    private AtomicInteger count;

    private Semaphore o;

    public H2O() {
        h = new Semaphore(2);
        o = new Semaphore(0);
        count = new AtomicInteger();
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

        h.acquire();

        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();

        int c = count.incrementAndGet();
        if ((c & 1) == 0) {
            o.release(1);
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {

        o.acquire();

        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();

        h.release(2);
    }
}
