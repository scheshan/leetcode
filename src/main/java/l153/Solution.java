package l153;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/19
 */
public class Solution {

    public int findMin(int[] nums) {
        if (nums.length == 1 || nums[0] < nums[nums.length - 1]) {
            return nums[0];
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (mid > 0 && nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }
            if (mid < nums.length - 1 && nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
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
        int res = new Solution().findMin(new int[]{3, 1, 2});
        System.out.println(res);
    }
}
