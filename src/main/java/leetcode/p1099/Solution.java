package leetcode.p1099;

import java.util.Arrays;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/18
 */
public class Solution {

    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);

        int res = -1;

        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int n = nums[l] + nums[r];
            if (n >= k) {
                r--;
            } else {
                if (n > res) {
                    res = n;
                }
                l++;
            }
        }
        return res;
    }
}
