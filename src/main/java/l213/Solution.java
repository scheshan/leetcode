package l213;

import java.util.Arrays;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/12
 */
public class Solution {

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        return Math.max(
                doRob(Arrays.copyOf(nums, nums.length - 1)),
                doRob(Arrays.copyOfRange(nums, 1, nums.length))
        );
    }

    private int doRob(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (i == 1) {
                nums[i] = Math.max(nums[i - 1], nums[i]);
            } else {
                nums[i] = Math.max(nums[i - 2] + nums[i], nums[i - 1]);
            }
        }

        return nums[nums.length - 1];
    }

    public static void main(String[] args) {
        new Solution().rob(new int[]{1, 3, 1, 3, 100});
    }
}
