package leetcode.p2656;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/11/15
 */
public class Solution {

    public int maximizeSum(int[] nums, int k) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }

        int n1 = max;
        int n2 = max + k - 1;

        return (n1 + n2) * k / 2;
    }
}
