package leetcode.p75;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/2/1
 */
public class Solution {

    public void sortColors(int[] nums) {
        int slow = 0, l = 0, r = nums.length - 1;

        while (l <= r) {
            int num = nums[l];
            if (num == 2) {
                swap(nums, l, r);
                r--;
            } else if (num == 0) {
                swap(nums, slow, l);
                slow++;
                l++;
            } else {
                l++;
            }
        }

        while (slow <= r) {
            nums[slow++] = 1;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int d = nums[i];
        nums[i] = nums[j];
        nums[j] = d;
    }
}
