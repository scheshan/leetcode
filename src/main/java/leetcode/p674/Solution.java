package leetcode.p674;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/28
 */
public class Solution {

    public int findLengthOfLCIS(int[] nums) {
        int res = 1;

        int cur = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0) {
                if (nums[i] > nums[i - 1]) {
                    cur++;
                    res = Math.max(res, cur);
                } else {
                    cur = 1;
                }
            }
        }
        return res;
    }
}
