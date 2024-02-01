package leetcode.p901;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/2/1
 */
public class StockSpanner {

    private Deque<int[]> deque;

    private int ind;

    public StockSpanner() {
        deque = new LinkedList<>();
    }

    public int next(int price) {
        int now = ++ind;

        while (!deque.isEmpty() && deque.peekLast()[1] <= price) {
            deque.removeLast();
        }

        int[] arr = new int[]{now, price};

        int res = now;
        if (!deque.isEmpty()) {
            res = now - deque.peekLast()[0];
        }

        deque.addLast(arr);
        return res;
    }
}
