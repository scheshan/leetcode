package l70;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/22
 */
public class Solution {

    public int climbStairs(int n) {
        if (n < 2) {
            return n;
        }

        int x = 1;
        int y = 2;

        for (int i = 2; i < n; i++) {
            int sum = x + y;
            x = y;
            y = sum;
        }
        return y;
    }
}
