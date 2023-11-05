package leetcode.p35;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/11/5
 */
public class Solution {

    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length;

        while (l < r) {
            int m = l + ((r - l) >> 1);
            if (nums[m] == target) {
                return m;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return l;
    }
}
