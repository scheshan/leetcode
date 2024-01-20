package leetcode.p268;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/21
 */
public class Solution {

    public int missingNumber(int[] nums) {
        int sum = (1 + nums.length) * nums.length >> 1;

        for (int num : nums) {
            sum -= num;
        }

        return sum;
    }
}
