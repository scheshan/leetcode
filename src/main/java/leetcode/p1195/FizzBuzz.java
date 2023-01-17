package leetcode.p1195;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * FizzBuzz
 *
 * @author heshan
 * @date 2023/1/17
 */
public class FizzBuzz {

    private int n;

    private volatile int cur;

    private Semaphore semaphore;

    private Semaphore s3;

    private Semaphore s5;

    private Semaphore s15;

    public FizzBuzz(int n) {
        this.n = n;
        this.cur = 1;

        semaphore = new Semaphore(1);
        s3 = new Semaphore(0);
        s5 = new Semaphore(0);
        s15 = new Semaphore(0);
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (this.cur <= n) {
            s3.acquire();
            if (cur <= n) {
                printFizz.run();
            }
            incr();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (this.cur <= n) {
            s5.acquire();
            if (cur <= n) {
                printBuzz.run();
            }
            incr();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (this.cur <= n) {
            s15.acquire();
            if (cur <= n) {
                printFizzBuzz.run();
            }
            incr();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (this.cur <= n) {
            semaphore.acquire();
            if (cur <= n) {
                printNumber.accept(cur);
            }
            incr();
        }
    }

    private void incr() {
        this.cur++;

        if (cur <= n) {
            if (this.cur % 3 == 0 && this.cur % 5 == 0) {
                s15.release(1);
            } else if (this.cur % 3 == 0) {
                s3.release(1);
            } else if (this.cur % 5 == 0) {
                s5.release(1);
            } else {
                semaphore.release(1);
            }
        } else {
            semaphore.release();
            s15.release();
            s3.release();
            s5.release();
        }
    }
}
