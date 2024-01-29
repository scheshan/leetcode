package leetcode.p739;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/29
 */
public class Solution {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Deque<Integer> deque = new ArrayDeque<>(temperatures.length);

        for (int i = 0; i < temperatures.length; i++) {
            while (!deque.isEmpty() && temperatures[deque.peekLast()] < temperatures[i]) {
                int n = deque.removeLast();
                res[n] = i - n;
            }
            deque.addLast(i);
        }

        return res;
    }
}
