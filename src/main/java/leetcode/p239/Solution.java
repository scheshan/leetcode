package leetcode.p239;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/1
 */
public class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new ArrayDeque<>(k << 1);
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && queue.peekFirst() < i - k + 1) {
                queue.removeFirst();
            }
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.removeLast();
            }
            queue.addLast(i);
            if (i >= k - 1) {
                res[i - k + 1] = nums[queue.peekFirst()];
            }
        }
        return res;
    }
}
