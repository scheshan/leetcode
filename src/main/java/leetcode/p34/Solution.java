package leetcode.p34;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/2/1
 */
public class Solution {

    public int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            int num = nums[mid];
            if (num == target) {
                return new int[]{findLeft(nums, 0, mid, target), findRight(nums, mid, nums.length - 1, target)};
            } else if (num < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return new int[]{-1, -1};
    }

    private int findLeft(int[] nums, int l, int r, int target) {
        int res = r;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            int num = nums[mid];
            if (num == target) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }

    private int findRight(int[] nums, int l, int r, int target) {
        int res = l;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            int num = nums[mid];
            if (num == target) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }
}
