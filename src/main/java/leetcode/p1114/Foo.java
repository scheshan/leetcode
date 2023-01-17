package leetcode.p1114;

import java.util.concurrent.Semaphore;

/**
 * Foo
 *
 * @author heshan
 * @date 2023/1/17
 */
public class Foo {

    private Semaphore s1;

    private Semaphore s2;

    private Semaphore s3;

    public Foo() {
        s1 = new Semaphore(1);
        s2 = new Semaphore(0);
        s3 = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        s1.acquire();
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();

        s2.release(1);
    }

    public void second(Runnable printSecond) throws InterruptedException {
        s2.acquire();

        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();

        s3.release(1);
    }

    public void third(Runnable printThird) throws InterruptedException {
        s3.acquire();

        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();

        s1.release(1);
    }
}
