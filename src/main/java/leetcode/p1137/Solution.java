package leetcode.p1137;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/28
 */
public class Solution {

    public int tribonacci(int n) {
        if (n <= 1) {
            return n;
        } else if (n == 2) {
            return 1;
        }

        int n0 = 0, n1 = 1, n2 = 1;
        for (int i = 3; i <= n; i++) {
            int num = n0 + n1 + n2;
            n0 = n1;
            n1 = n2;
            n2 = num;
        }

        return n2;
    }
}
