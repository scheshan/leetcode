package l509;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/22
 */
public class Solution {

    public int fib(int n) {
        if (n < 2) {
            return n;
        }

        int x = 0;
        int y = 1;
        for (int i = 2; i <= n; i++) {
            int sum = (x + y) % 1000000007;
            x = y;
            y = sum;
        }
        return y;
    }
}
