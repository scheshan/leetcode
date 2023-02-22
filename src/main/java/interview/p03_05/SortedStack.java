package interview.p03_05;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * SortedStack
 *
 * @author heshan
 * @date 2023/2/22
 */
public class SortedStack {

    private Deque<Integer> d1;

    private Deque<Integer> d2;

    public SortedStack() {
        d1 = new ArrayDeque<>();
        d2 = new ArrayDeque<>();
    }

    public void push(int val) {
        while (!d1.isEmpty() && d1.peekLast() < val) {
            d2.addLast(d1.removeLast());
        }
        d1.addLast(val);
        while (!d2.isEmpty()) {
            d1.addLast(d2.removeLast());
        }
    }

    public void pop() {
        if (!d1.isEmpty()) {
            d1.removeLast();
        }
    }

    public int peek() {
        if (!d1.isEmpty()) {
            return d1.peekLast();
        }
        return -1;
    }

    public boolean isEmpty() {
        return d1.isEmpty();
    }
}
