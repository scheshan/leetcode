package leetcode.p1800;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/2
 */
public class Solution {

    public int maxAscendingSum(int[] nums) {
        int res = 0;

        int cur = 0;
        int pre = 0;
        for (int num : nums) {
            if (num > pre) {
                cur += num;
            } else {
                cur = num;
            }
            pre = num;
            res = Math.max(res, cur);
        }
        return res;
    }
}
