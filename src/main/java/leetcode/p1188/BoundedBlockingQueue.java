package leetcode.p1188;

import java.lang.annotation.ElementType;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * BoundedBlockingQueue
 *
 * @author heshan
 * @date 2023/1/17
 */
public class BoundedBlockingQueue {

    private Queue<Integer> queue;

    private volatile int size;

    private ReentrantLock lock;

    private Condition notFull;

    private Condition notEmpty;

    public BoundedBlockingQueue(int capacity) {
        queue = new LinkedList<>();
        lock = new ReentrantLock();
        notFull = lock.newCondition();
        notEmpty = lock.newCondition();
        size = capacity;
    }

    public void enqueue(int element) throws InterruptedException {
        lock.lock();
        try {
            while (size == queue.size()) {
                notFull.await();
            }
            queue.add(element);

            notEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public int dequeue() throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() == 0) {
                notEmpty.await();
            }

            int res = queue.remove();
            notFull.signalAll();
            return res;
        } finally {
            lock.unlock();
        }
    }

    public int size() {
        return queue.size();
    }
}
