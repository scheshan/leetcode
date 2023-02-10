package leetcode.p2044;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/10
 */
public class Solution {

    private int max;

    private int cnt;

    public int countMaxOrSubsets(int[] nums) {
        backtrack(nums, 0, 0);
        return cnt;
    }

    private void backtrack(int[] nums, int ind, int cur) {
        if (ind > 0) {
            if (cur > max) {
                max = cur;
                cnt = 1;
            } else if (cur == max) {
                cnt++;
            }
        }

        if (ind == nums.length) {
            return;
        }

        for (int i = ind; i < nums.length; i++) {
            backtrack(nums, i + 1, cur | nums[i]);
        }
    }
}
