package leetcode.p1863;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/28
 */
public class Solution {

    public int subsetXORSum(int[] nums) {
        return perm(nums, 0, 0);
    }

    private int perm(int[] nums, int ind, int cur) {
        int res = cur;
        for (int i = ind; i < nums.length; i++) {
            cur ^= nums[i];
            res += perm(nums, i + 1, cur);
            cur ^= nums[i];
        }
        return res;
    }
}
