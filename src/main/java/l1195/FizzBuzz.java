package l1195;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * FizzBuzz
 *
 * @author heshan
 * @date 2020/3/23
 */
public class FizzBuzz {

    private int n;

    private int cur = 1;

    private Semaphore fizz;

    private Semaphore buzz;

    private Semaphore fizzBuzz;

    private Semaphore number;

    public FizzBuzz(int n) {
        this.n = n;

        number = new Semaphore(1);
        fizz = new Semaphore(0);
        buzz = new Semaphore(0);
        fizzBuzz = new Semaphore(0);
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (true) {
            fizz.acquire();
            if (cur > n) {
                return;
            }

            printFizz.run();

            increase();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (true) {
            buzz.acquire();
            if (cur > n) {
                return;
            }

            printBuzz.run();

            increase();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (true) {
            fizzBuzz.acquire();
            if (cur > n) {
                return;
            }

            printFizzBuzz.run();

            increase();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            number.acquire();
            if (cur > n) {
                return;
            }

            printNumber.accept(cur);

            increase();
        }
    }

    private void increase() {
        cur++;

        if (cur <= n) {
            if (cur % 15 == 0) {
                fizzBuzz.release();
            } else if (cur % 5 == 0) {
                buzz.release();
            } else if (cur % 3 == 0) {
                fizz.release();
            } else {
                number.release();
            }
        } else {
            fizzBuzz.release();
            buzz.release();
            fizz.release();
            number.release();
        }
    }

    public static void main(String[] args) {
        FizzBuzz fb = new FizzBuzz(15);

        new Thread(() -> {
            try {
                fb.fizz(() -> {
                    System.out.println("fizz");
                });
            } catch (InterruptedException ex) {

            }
        }).start();
        new Thread(() -> {
            try {
                fb.buzz(() -> {
                    System.out.println("buzz");
                });
            } catch (InterruptedException ex) {

            }
        }).start();
        new Thread(() -> {
            try {
                fb.fizzbuzz(() -> {
                    System.out.println("fizzbuzz");
                });
            } catch (InterruptedException ex) {

            }
        }).start();
        new Thread(() -> {
            try {
                fb.number(i -> {
                    System.out.println(i);
                });
            } catch (InterruptedException ex) {

            }
        }).start();
    }
}
