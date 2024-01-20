package leetcode.p26;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/11/15
 */
public class Solution {

    public int removeDuplicates(int[] nums) {
        int l = 0;
        int r = 0;

        while (r < nums.length) {
            nums[l] = nums[r];

            l++;
            r++;
            while (r < nums.length && nums[r] == nums[r - 1]) {
                r++;
            }
        }

        return l;
    }
}
