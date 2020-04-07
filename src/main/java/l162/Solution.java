package l162;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/7
 */
public class Solution {

    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = (left + right) / 2;

            if (mid == 0) {
                return nums[mid] > nums[mid + 1] ? mid : mid + 1;
            } else if (mid == nums.length - 1) {
                return nums[mid] > nums[mid - 1] ? mid : mid - 1;
            }

            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }

            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        new Solution().findPeakElement(new int[]{3, 2, 1});
    }
}
