package leetcode.p487;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/28
 */
public class Solution {

    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0, l = 0, r = 0, exist = 1;

        while (r < nums.length) {
            if (nums[r++] == 0) {
                exist--;
                while (exist < 0) {
                    if (nums[l++] == 0) {
                        exist++;
                    }
                }
            }
            res = Math.max(res, r - l);
        }

        return res;
    }
}
