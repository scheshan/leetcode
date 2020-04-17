package l55;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/17
 */
public class Solution {

    public boolean canJump(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) {
                nums[i] = Math.max(nums[i - 1] - 1, nums[i]);
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        new Solution().canJump(new int[]{2, 3, 1, 1, 4});
    }
}
