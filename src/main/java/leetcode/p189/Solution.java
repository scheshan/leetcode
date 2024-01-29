package leetcode.p189;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/29
 */
public class Solution {

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        if (k == 0) {
            return;
        }

        rotate(nums, 0, nums.length - 1);
        rotate(nums, 0, k - 1);
        rotate(nums, k, nums.length - 1);
    }

    private void rotate(int[] nums, int l, int r) {
        while (l < r) {
            int d = nums[l];
            nums[l] = nums[r];
            nums[r] = d;
            l++;
            r--;
        }
    }
}
