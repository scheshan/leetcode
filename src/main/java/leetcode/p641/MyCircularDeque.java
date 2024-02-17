package leetcode.p641;

/**
 * MyCircularDeque
 *
 * @author heshan
 * @date 2024/2/18
 */
public class MyCircularDeque {

    private int[] nums;

    private int head;

    private int tail;

    private int size;

    public MyCircularDeque(int k) {
        nums = new int[k];
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }

        head = getIndex(head - 1);
        nums[head] = value;
        size++;

        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }

        nums[tail] = value;
        tail = getIndex(tail + 1);
        size++;

        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }

        head = getIndex(head + 1);
        size--;

        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }

        tail = getIndex(tail - 1);
        size--;

        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }

        return nums[head];
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }

        return nums[getIndex(tail - 1)];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == nums.length;
    }

    private int getIndex(int ind) {
        if (ind < 0) {
            ind += nums.length;
        } else if (ind >= nums.length) {
            ind -= nums.length;
        }

        return ind;
    }
}
