package leetcode.p34;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/31
 */
public class Solution {

    public int[] searchRange(int[] nums, int target) {
        int l = 0;
        int r = nums.length;
        int left = -1;

        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] < target) {
                left = mid;
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        l = 0;
        r = nums.length;
        int right = nums.length;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] > target) {
                right = mid;
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        if (right == left + 1) {
            return new int[]{-1, -1};
        }
        return new int[]{left + 1, right - 1};
    }
}
