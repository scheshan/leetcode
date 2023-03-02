package leetcode.p1150;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/2
 */
public class Solution {

    public boolean isMajorityElement(int[] nums, int target) {
        int left = findLesser(nums, target);
        int right = findLarger(nums, target);
        return right - left - 1 > nums.length >> 1;
    }

    private int findLesser(int[] nums, int target) {
        int res = -1;
        int l = 0;
        int r = nums.length;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] < target) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return res;
    }

    private int findLarger(int[] nums, int target) {
        int res = nums.length;
        int l = 0;
        int r = nums.length;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] > target) {
                res = mid;
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }
}
