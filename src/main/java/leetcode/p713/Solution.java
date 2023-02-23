package leetcode.p713;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/23
 */
public class Solution {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int cur = 1;
        int l = 0;
        int r = 0;
        int res = 0;

        while (r < nums.length) {
            cur *= nums[r++];
            while (l < r && cur >= k) {
                cur /= nums[l++];
            }
            res += r - l;
        }

        return res;
    }
}
