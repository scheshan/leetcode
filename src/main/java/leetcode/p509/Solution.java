package leetcode.p509;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/27
 */
public class Solution {

    public int fib(int n) {
        if (n <= 1) {
            return n;
        }

        int n1 = 0;
        int n2 = 1;

        for (int i = 2; i <= n; i++) {
            int n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
        }
        return n2;
    }
}
