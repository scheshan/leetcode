package m10_ii;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/21
 */
public class Solution {

    public int numWays(int n) {
        if (n <= 1) {
            return 1;
        }

        int x = 1;
        int y = 2;
        for (int i = 3; i <= n; i++) {
            int sum = (x + y) % 1000000007;
            x = y;
            y = sum;
        }
        return y;
    }
}
