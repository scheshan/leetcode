package l34;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/2
 */
public class Solution {

    int left;
    int right;

    public int[] searchRange(int[] nums, int target) {
        left = nums.length;
        right = -1;

        search(nums, target, 0, nums.length);

        if (left == nums.length) {
            return new int[]{-1, -1};
        } else {
            return new int[]{left, right};
        }
    }

    private void search(int[] nums, int target, int l, int r) {
        while (l < r) {
            int mid = (l + r) / 2;

            if (nums[mid] == target) {
                left = Math.min(left, mid);
                right = Math.max(right, mid);

                search(nums, target, l, mid);
                search(nums, target, mid + 1, r);
                break;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
    }

    public static void main(String[] args) {
        new Solution().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
    }
}
