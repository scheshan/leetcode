package leetcode.p172;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/28
 */
public class Solution {

    public int trailingZeroes(int n) {
        int res = 0;

        while (n != 0) {
            n /= 5;
            res += n;
        }

        return res;
    }
}
