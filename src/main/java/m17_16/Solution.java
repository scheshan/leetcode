package m17_16;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/24
 */
public class Solution {

    public int massage(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        nums[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            nums[i] = Math.max(nums[i] + nums[i - 2], nums[i - 1]);
        }

        return Math.max(nums[nums.length - 2], nums[nums.length - 1]);
    }

    public static void main(String[] args) {
        new Solution().massage(new int[]{2, 1, 1, 2});
    }
}
