package l204;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/19
 */
public class Solution {

    public int countPrimes(int n) {
        boolean[] dp = new boolean[n + 1];

        int res = 0;
        for (int i = 2; i < n; i++) {
            if (dp[i]) {
                continue;
            }

            res++;

            for (int j = 1; j * i <= n; j++) {
                dp[j * i] = true;
            }
        }

        return res;
    }
}
