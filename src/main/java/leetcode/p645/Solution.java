package leetcode.p645;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/2
 */
public class Solution {

    public int[] findErrorNums(int[] nums) {
        int w1 = -1;
        int w2 = -1;

        for (int num : nums) {
            int ind = Math.abs(num) - 1;
            if (nums[ind] < 0) {
                w1 = Math.abs(num);
            } else {
                nums[ind] *= -1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                w2 = i + 1;
            }
        }

        return new int[]{w1, w2};
    }
}
