package leetcode.p1732;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/28
 */
public class Solution {

    public int largestAltitude(int[] gain) {
        int res = 0, cur = 0;

        for (int num : gain) {
            cur += num;
            res = Math.max(res, cur);
        }

        return res;
    }
}
