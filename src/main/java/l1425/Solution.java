package l1425;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/26
 */
public class Solution {

    public int constrainedSubsetSum(int[] nums, int k) {
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;

        Deque<int[]> queue = new LinkedList<>();

        int res = Integer.MIN_VALUE;
        for (int i = 1; i <= nums.length; i++) {
            dp[i] = nums[i - 1];

            while (!queue.isEmpty() && queue.peekFirst()[0] < i - k) {
                queue.removeFirst();
            }

            int max = 0;
            if (!queue.isEmpty()) {
                max = queue.peekFirst()[1];
            }
            dp[i] = Math.max(nums[i - 1] + max, dp[i]);

            while (!queue.isEmpty() && queue.peekLast()[1] < dp[i]) {
                queue.removeLast();
            }
            queue.addLast(new int[]{i, dp[i]});

            res = Math.max(res, dp[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        int res = new Solution().constrainedSubsetSum(new int[]{10,2,-10,5,20}, 2);
        System.out.println(res);
    }
}
