package leetcode.p1848;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/16
 */
public class Solution {

    public int getMinDistance(int[] nums, int target, int start) {
        if (nums[start] == target) {
            return 0;
        }

        int l = start - 1;
        int r = start + 1;
        while (l >= 0 || r < nums.length) {
            if (l >= 0 && nums[l] == target) {
                return start - l;
            }
            if (r < nums.length && nums[r] == target) {
                return r - start;
            }

            l--;
            r++;
        }
        return 0;
    }
}
