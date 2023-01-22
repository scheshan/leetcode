package leetcode.p461;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/22
 */
public class Solution {

    public int hammingDistance(int x, int y) {
        int res = 0;
        int n = x ^ y;
        while (n != 0) {
            res++;
            n = n & (n - 1);
        }
        return res;
    }
}
