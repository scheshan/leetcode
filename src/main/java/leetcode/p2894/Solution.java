package leetcode.p2894;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/29
 */
public class Solution {

    public int differenceOfSums(int n, int m) {
        int res = 0;

        for (int i = 0; i <= n; i++) {
            if (i % m == 0) {
                res -= i;
            } else {
                res += i;
            }
        }

        return res;
    }
}