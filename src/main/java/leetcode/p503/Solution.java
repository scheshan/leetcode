package leetcode.p503;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/29
 */
public class Solution {

    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];

        Deque<Integer> deque = new ArrayDeque<>(nums.length);
        int queueIndex = 0;

        for (int i = nums.length - 1; i >= 0; i--) {
            while (!deque.isEmpty() && deque.peekLast() <= nums[i]) {
                deque.removeLast();
            }

            if (deque.isEmpty()) {
                while (queueIndex < nums.length && nums[queueIndex] <= nums[i]) {
                    queueIndex++;
                }
                if (queueIndex == nums.length) {
                    res[i] = -1;
                } else {
                    res[i] = nums[queueIndex];
                }
            } else {
                res[i] = deque.peekLast();
            }
            deque.addLast(nums[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution().nextGreaterElements(new int[]{5, 4, 3, 2, 1});
    }
}
