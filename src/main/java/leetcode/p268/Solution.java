package leetcode.p268;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/14
 */
public class Solution {

    public int missingNumber(int[] nums) {
        int total = (1 + nums.length) * nums.length / 2;
        for (int num : nums) {
            total -= num;
        }
        return total;
    }
}
