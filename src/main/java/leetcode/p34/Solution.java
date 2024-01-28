package leetcode.p34;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/28
 */
public class Solution {

    public int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int mid = l + ((r - l) >> 1);

            if (nums[mid] == target) {
                return new int[]{left(nums, l, mid, target), right(nums, mid, r, target)};
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return new int[]{-1, -1};
    }

    private int left(int[] nums, int l, int r, int target) {
        int res = r;

        while (l <= r) {
            int mid = l + ((r - l) >> 1);

            if (nums[mid] >= target) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return res;
    }

    private int right(int[] nums, int l, int r, int target) {
        int res = l;

        while (l <= r) {
            int mid = l + ((r - l) >> 1);

            if (nums[mid] <= target) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return res;
    }
}
