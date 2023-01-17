package leetcode.p27;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/18
 */
public class Solution {

    public int removeElement(int[] nums, int val) {
        int l = 0;
        int r = 0;

        while (r < nums.length) {
            if (nums[r] != val) {
                if (l < r) {
                    int tmp = nums[l];
                    nums[l] = nums[r];
                    nums[r] = tmp;
                }
                l++;
            }
            r++;
        }

        return l;
    }
}
