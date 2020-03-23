package l198;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/23
 */
public class Solution {

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }

        nums[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            nums[i] = Math.max(nums[i - 2] + nums[i], nums[i - 1]);
        }

        return Math.max(nums[nums.length - 1], nums[nums.length - 2]);
    }

    public static void main(String[] args) {
        new Solution().rob(new int[]{2, 1, 1, 2});
    }
}
