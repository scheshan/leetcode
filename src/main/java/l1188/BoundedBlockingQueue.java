package l1188;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/24
 */
public class BoundedBlockingQueue {

    private Queue<Integer> queue;

    private Lock lock;

    private Condition nonFull;

    private Condition nonEmpty;

    private int capacity;

    public BoundedBlockingQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new LinkedList<>();
        lock = new ReentrantLock();
        nonFull = lock.newCondition();
        nonEmpty = lock.newCondition();
    }

    public void enqueue(int element) throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() == capacity) {
                nonFull.await();
            }
            queue.add(element);
            nonEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public int dequeue() throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() == 0) {
                nonEmpty.await();
            }
            int res = queue.remove();
            nonFull.signalAll();
            return res;
        } finally {
            lock.unlock();
        }
    }

    public int size() {
        return queue.size();
    }
}
