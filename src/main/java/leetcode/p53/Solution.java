package leetcode.p53;

/**
 * Soluton
 *
 * @author heshan
 * @date 2023/2/1
 */
public class Solution {

    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int cur = 0;

        for (int num : nums) {
            cur += num;
            res = Math.max(res, cur);
            if (cur < 0) {
                cur = 0;
            }
        }
        return res;
    }
}
