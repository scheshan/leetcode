package leetcode.p27;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/11/5
 */
public class Solution {

    public int removeElement(int[] nums, int val) {
        int l = 0, r = 0;
        while (r < nums.length) {
            int n = nums[r++];
            if (n != val) {
                nums[l++] = n;
            }
        }

        return l;
    }
}
