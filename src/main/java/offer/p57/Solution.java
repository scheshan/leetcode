package offer.p57;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/16
 */
public class Solution {

    public int[] twoSum(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int n = nums[l] + nums[r];
            if (n == target) {
                return new int[]{nums[l], nums[r]};
            } else if (n < target) {
                l++;
            } else {
                r--;
            }
        }

        return null;
    }
}
