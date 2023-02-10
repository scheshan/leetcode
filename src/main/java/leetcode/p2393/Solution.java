package leetcode.p2393;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/26
 */
public class Solution {

    public long countSubarrays(int[] nums) {
        long res = 0;

        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] > nums[i - 1]) {
                continue;
            }

            long len = i - pre;
            res += ((1 + len) * len) >> 1;
            pre = i;
        }
        long len = nums.length - pre;
        res += (1 + len) * (len >> 1);

        return res;
    }
}
