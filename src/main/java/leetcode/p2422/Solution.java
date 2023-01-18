package leetcode.p2422;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/18
 */
public class Solution {

    public int minimumOperations(int[] nums) {
        int res = 0;

        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            if (nums[l] == nums[r]) {
                l++;
                r--;
            } else if (nums[l] < nums[r]) {
                nums[l + 1] += nums[l];
                l++;
                res++;
            } else {
                nums[r - 1] += nums[r];
                r--;
                res++;
            }
        }

        return res;
    }
}
