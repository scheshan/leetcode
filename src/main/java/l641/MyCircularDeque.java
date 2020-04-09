package l641;

/**
 * MyCircularDeque
 *
 * @author heshan
 * @date 2020/4/9
 */
public class MyCircularDeque {

    private int[] items;

    private int size;

    private int left;

    private int right;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        items = new int[k];
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }

        left--;
        if (left < 0) {
            left = items.length - 1;
        }

        items[left] = value;
        size++;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }

        items[right] = value;
        right++;
        if (right == items.length) {
            right = 0;
        }
        size++;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }

        left++;
        if (left == items.length) {
            left = 0;
        }

        size--;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }

        right--;
        if (right < 0) {
            right = items.length - 1;
        }

        size--;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }

        return items[left];
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }

        int ind = right - 1;
        if (ind < 0) {
            ind = items.length - 1;
        }

        return items[ind];
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return size == items.length;
    }
}
