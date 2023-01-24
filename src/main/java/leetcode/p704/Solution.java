package leetcode.p704;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/24
 */
public class Solution {

    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length;

        while (l < r) {
            int mid = l + ((r - l) >> 1);
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if (num < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return -1;
    }
}
