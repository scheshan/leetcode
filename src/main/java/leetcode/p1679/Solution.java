package leetcode.p1679;

import java.util.Arrays;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/28
 */
public class Solution {

    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1, res = 0;

        while (l < r) {
            int n = nums[l] + nums[r];
            if (n == k) {
                l++;
                r--;
                res++;
            } else if (n < k) {
                l++;
            } else {
                r--;
            }
        }

        return res;
    }
}
