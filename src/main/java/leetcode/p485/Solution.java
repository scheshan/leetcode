package leetcode.p485;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/30
 */
public class Solution {

    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;

        int cur = 0;
        for (int num : nums) {
            if (num == 1) {
                cur++;
            } else {
                res = Math.max(res, cur);
                cur = 0;
            }
        }
        res = Math.max(res, cur);
        return res;
    }
}
