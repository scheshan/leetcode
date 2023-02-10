package leetcode.p2293;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/3
 */
public class Solution {

    public int minMaxGame(int[] nums) {
        return get(nums, 0, nums.length, true);
    }

    private int get(int[] nums, int left, int right, boolean min) {
        int n1;
        int n2;

        if (left < right - 2) {
            int mid = left + ((right - left) >> 1);
            n1 = get(nums, left, mid, true);
            n2 = get(nums, mid, right, false);
        } else {
            n1 = nums[left];
            n2 = nums[right - 1];
        }

        if (min) {
            return Math.min(n1, n2);
        }
        return Math.max(n1, n2);
    }
}
