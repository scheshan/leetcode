package leetcode.p283;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/18
 */
public class Solution {

    public void moveZeroes(int[] nums) {
        int ind = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (ind != i) {
                    nums[ind] = nums[i];
                }
                ind++;
            }
        }

        while (ind < nums.length) {
            nums[ind++] = 0;
        }
    }
}
