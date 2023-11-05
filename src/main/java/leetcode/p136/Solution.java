package leetcode.p136;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/11/5
 */
public class Solution {

    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }

        return res;
    }
}
