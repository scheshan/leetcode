package leetcode.p485;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/28
 */
public class Solution {

    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;

        int ind = 0, cnt = 0;
        while (ind < nums.length) {
            cnt = 0;
            while (ind < nums.length && nums[ind] == 1) {
                cnt++;
                ind++;
            }

            res = Math.max(res, cnt);

            while (ind < nums.length && nums[ind] == 0) {
                ind++;
            }
        }

        return res;
    }
}
