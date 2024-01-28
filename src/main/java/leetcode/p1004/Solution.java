package leetcode.p1004;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/28
 */
public class Solution {

    public int longestOnes(int[] nums, int k) {
        int l = 0, r = 0, res = 0;

        while (r < nums.length) {
            if (nums[r++] != 1) {
                k--;
            }
            while (k < 0) {
                if (nums[l++] == 0) {
                    k++;
                }
            }
            res = Math.max(res, r - l);
        }

        return res;
    }
}
