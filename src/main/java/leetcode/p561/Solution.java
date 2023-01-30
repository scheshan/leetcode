package leetcode.p561;

import java.util.Arrays;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/30
 */
public class Solution {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i += 2) {
            res += nums[i];
        }
        return res;
    }
}
