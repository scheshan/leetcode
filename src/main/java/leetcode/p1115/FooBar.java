package leetcode.p1115;

import java.util.concurrent.Semaphore;

/**
 * FooBar
 *
 * @author heshan
 * @date 2023/1/17
 */
public class FooBar {

    private Semaphore s1;

    private Semaphore s2;

    private int n;

    public FooBar(int n) {
        this.n = n;
        s1 = new Semaphore(1);
        s2 = new Semaphore(0);
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            s1.acquire();

            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();

            s2.release(1);
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            s2.acquire();

            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();

            s1.release(1);
        }
    }
}
