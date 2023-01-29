package leetcode.p1887;

import java.util.Arrays;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/29
 */
public class Solution {

    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int res = 0;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                res += nums.length - i - 1;
            }
        }
        return res;
    }
}
