package l33;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/27
 */
public class Solution {

    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        int left = findMin(nums);
        int right = left + nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid % nums.length] == target) {
                return mid % nums.length;
            } else if (nums[mid % nums.length] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return -1;
    }

    private int findMin(int[] nums) {
        if (nums.length == 1 || nums[0] < nums[nums.length - 1]) {
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (mid > 0 && nums[mid - 1] > nums[mid]) {
                return mid;
            }
            if (mid < nums.length - 1 && nums[mid] > nums[mid + 1]) {
                return mid + 1;
            }

            if (nums[left] < nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int res = new Solution().search(new int[]{1, 3}, 3);
        System.out.println(res);
    }
}
