package offer.p10_01;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/18
 */
public class Solution {

    public int fib(int n) {
        if (n <= 1) {
            return n;
        }

        int n1 = 0;
        int n2 = 1;

        for (int i = 2; i <= n; i++) {
            int t = (n1 + n2) % 1000000007;
            n1 = n2;
            n2 = t;
        }

        return n2;
    }
}
