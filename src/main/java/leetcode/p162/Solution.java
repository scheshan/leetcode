package leetcode.p162;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/22
 */
public class Solution {

    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        int l = 0;
        int r = nums.length;

        while (l < r) {
            int mid = l + ((r - l) >> 1);
            int num = nums[mid];

            if (mid == 0) {
                if (num > nums[1]) {
                    return mid;
                }
                l = 1;
            } else if (mid == nums.length - 1) {
                if (num > nums[mid - 1]) {
                    return mid;
                }
                r = mid;
            } else if (num > nums[mid - 1] && num > nums[mid + 1]) {
                return mid;
            } else if (num < nums[mid - 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}
