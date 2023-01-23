package leetcode.p1732;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/23
 */
public class Solution {

    public int largestAltitude(int[] gain) {
        int res = 0;
        int cur = 0;
        for (int num : gain) {
            cur += num;
            res = Math.max(res, cur);
        }
        return res;
    }
}
