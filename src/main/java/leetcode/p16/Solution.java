package leetcode.p16;

import java.util.Arrays;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/27
 */
public class Solution {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int res = nums[0] + nums[1] + nums[2];
        int total = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1, r = nums.length - 1;

            while (l < r) {
                total = nums[i] + nums[l] + nums[r];

                if (Math.abs(target - total) < Math.abs(target - res)) {
                    res = total;
                }
                if (total < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }

        return res;
    }
}
