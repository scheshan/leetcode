package leetcode.p1304;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/26
 */
public class Solution {

    public int[] sumZero(int n) {
        int[] res = new int[n];
        int cur = 1;
        for (int i = n & 1; i < res.length; i += 2) {
            res[i] = cur;
            res[i + 1] = -cur;
            cur++;
        }
        return res;
    }
}
