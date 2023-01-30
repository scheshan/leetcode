package leetcode.p641;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/30
 */
public class MyCircularDeque {

    private int[] items;

    private int head;

    private int tail;

    private int size;

    public MyCircularDeque(int k) {
        this.items = new int[k];
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }

        head = decr(head);
        items[head] = value;
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }

        items[tail] = value;
        tail = incr(tail);
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }

        head = incr(head);
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }

        tail = decr(tail);
        size--;
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return items[head];
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return items[decr(tail)];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size >= items.length;
    }

    private int incr(int p) {
        p++;
        if (p >= items.length) {
            p = 0;
        }
        return p;
    }

    private int decr(int p) {
        p--;
        if (p < 0) {
            p = items.length - 1;
        }
        return p;
    }
}
