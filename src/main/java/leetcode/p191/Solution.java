package leetcode.p191;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/21
 */
public class Solution {

    public int hammingWeight(int n) {
        int res = 0;

        while (n != 0) {
            n = n & (n - 1);
            res++;
        }

        return res;
    }
}
