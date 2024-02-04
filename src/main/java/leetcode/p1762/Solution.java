package leetcode.p1762;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/2/5
 */
public class Solution {

    public int[] findBuildings(int[] heights) {
        Deque<Integer> deque = new ArrayDeque<>(heights.length);

        for (int i = 0; i < heights.length; i++) {
            while (!deque.isEmpty() && heights[deque.peekLast()] <= heights[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }

        int[] res = new int[deque.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = deque.removeFirst();
        }

        return res;
    }
}
