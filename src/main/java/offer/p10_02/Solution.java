package offer.p10_02;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/18
 */
public class Solution {

    public int numWays(int n) {
        if (n <= 1) {
            return 1;
        }

        int n1 = 1;
        int n2 = 2;
        for (int i = 2; i < n; i++) {
            int t = (n1 + n2) % 1000000007;
            n1 = n2;
            n2 = t;
        }
        return n2;
    }
}
