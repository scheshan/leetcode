package leetcode.p977;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/18
 */
public class Solution {

    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];

        int l = 0;
        int r = nums.length - 1;
        int ind = nums.length - 1;

        while (l <= r) {
            if (nums[l] * nums[l] < nums[r] * nums[r]) {
                res[ind--] = nums[r] * nums[r];
                r--;
            } else {
                res[ind--] = nums[l] * nums[l];
                l++;
            }
        }
        return res;
    }
}
