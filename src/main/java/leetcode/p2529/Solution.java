package leetcode.p2529;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/21
 */
public class Solution {

    public int maximumCount(int[] nums) {
        int x = findMaxNegative(nums);
        int y = findMinPositive(nums);

        if (x < 0 && y < 0) {
            return 0;
        } else if (x >= 0 && y >= 0) {
            return Math.max(x + 1, nums.length - y);
        } else {
            if (x < 0) {
                return nums.length - y;
            }
            return x + 1;
        }
    }

    private int findMinPositive(int[] nums) {
        int res = -1;
        int l = 0;
        int r = nums.length;

        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] > 0) {
                res = mid;
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }

    private int findMaxNegative(int[] nums) {
        int res = -1;
        int l = 0;
        int r = nums.length;

        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] < 0) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return res;
    }
}
