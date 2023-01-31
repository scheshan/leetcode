package leetcode.p1670;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/31
 */
public class FrontMiddleBackQueue {

    private Deque<Integer> q1;

    private Deque<Integer> q2;

    public FrontMiddleBackQueue() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void pushFront(int val) {
        q1.addFirst(val);
        if (q1.size() > q2.size()) {
            q2.addFirst(q1.removeLast());
        }
    }

    public void pushMiddle(int val) {
        if (q1.size() < q2.size()) {
            q1.addLast(val);
        } else {
            q2.addFirst(val);
        }
    }

    public void pushBack(int val) {
        if (q2.size() > q1.size()) {
            q1.addLast(q2.removeFirst());
        }

        q2.addLast(val);
    }

    public int popFront() {
        if (isEmpty()) {
            return -1;
        }

        if (q2.size() > q1.size()) {
            q1.addLast(q2.removeFirst());
        }

        return q1.removeFirst();
    }

    public int popMiddle() {
        if (isEmpty()) {
            return -1;
        }
        if (q1.size() == q2.size()) {
            return q1.removeLast();
        }
        return q2.removeFirst();
    }

    public int popBack() {
        if (isEmpty()) {
            return -1;
        }
        if (q1.size() == q2.size()) {
            q2.addFirst(q1.removeLast());
        }
        return q2.removeLast();
    }

    private boolean isEmpty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}
