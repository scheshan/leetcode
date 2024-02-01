package leetcode.p41;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/2/1
 */
public class Solution {

    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num < 0 || num >= nums.length) {
                continue;
            }

            while (num >= 1 && num < nums.length + 1 && num != nums[num - 1]) {
                int d = nums[num - 1];
                nums[num - 1] = num;
                num = d;
            }
        }

        int res = 0;
        while (res < nums.length) {
            if (nums[res] != res + 1) {
                return res + 1;
            }
            res++;
        }
        return res + 1;
    }
}
