package leetcode.p1762;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/21
 */
public class Solution {

    public int[] findBuildings(int[] heights) {
        Deque<Integer> deque = new ArrayDeque<>(heights.length);
        for (int i = heights.length - 1; i >= 0; i--) {
            if (deque.isEmpty() || heights[i] > heights[deque.peekFirst()]) {
                deque.addFirst(i);
            }
        }

        int[] res = new int[deque.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = deque.removeFirst();
        }
        return res;
    }
}
