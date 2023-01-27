package offer2.p038;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/27
 */
public class Solution {

    public int[] dailyTemperatures(int[] temperatures) {
        Deque<int[]> deque = new ArrayDeque<>();
        for (int i = temperatures.length - 1; i >= 0; i--) {
            int num = temperatures[i];
            while (!deque.isEmpty() && deque.peekLast()[1] <= num) {
                deque.removeLast();
            }
            if (deque.isEmpty()) {
                temperatures[i] = 0;
            } else {
                temperatures[i] = deque.peekLast()[0] - i;
            }
            deque.addLast(new int[]{i, num});
        }
        return temperatures;
    }
}
