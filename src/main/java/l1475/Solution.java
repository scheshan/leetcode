package l1475;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/6/15
 */
public class Solution {

    public int[] finalPrices(int[] prices) {
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            while (!deque.isEmpty() && prices[deque.peekLast()] >= prices[i]) {
                int j = deque.removeLast();
                res[j] = prices[j] - prices[i];
            }

            deque.addLast(i);
        }

        while(!deque.isEmpty()) {
            int j = deque.removeLast();
            res[j] = prices[j];
        }

        return res;
    }
}
