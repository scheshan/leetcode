package lcr.p038;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/2/5
 */
public class Solution {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];

        Deque<Integer> deque = new ArrayDeque<>(temperatures.length);
        for (int i = 0; i < temperatures.length; i++) {
            while (!deque.isEmpty() && temperatures[deque.peekLast()] < temperatures[i]) {
                int pre = deque.removeLast();
                res[pre] = i - pre;
            }
            deque.addLast(i);
        }

        return res;
    }
}
