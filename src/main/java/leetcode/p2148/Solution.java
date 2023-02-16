package leetcode.p2148;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/16
 */
public class Solution {

    public int countElements(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        int c1 = 0;
        int c2 = 0;

        for (int num : nums) {
            if (num < min) {
                min = num;
                c1 = 1;
            } else if (num == min) {
                c1++;
            }
            if (num > max) {
                max = num;
                c2 = 1;
            } else if (num == max) {
                c2++;
            }
        }

        return Math.max(0, nums.length - c1 - c2);
    }
}
