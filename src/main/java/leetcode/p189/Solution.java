package leetcode.p189;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/7
 */
public class Solution {

    public void rotate(int[] nums, int k) {
        if (k >= nums.length) {
            k %= nums.length;
        }
        if (k == 0) {
            return;
        }

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            int t = nums[l];
            nums[l] = nums[r];
            nums[r] = t;
            l++;
            r--;
        }
    }
}
