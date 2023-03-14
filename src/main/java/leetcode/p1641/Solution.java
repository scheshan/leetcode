package leetcode.p1641;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/7
 */
public class Solution {

    public int countVowelStrings(int n) {
        int[] dp = new int[5];
        for (int i = 0; i < 5; i++) {
            dp[i] = 1;
        }
        int res = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 4; j >= 0; j--) {
                int cnt = 0;
                for (int k = 0; k <= j; k++) {
                    cnt += dp[k];
                }
                dp[j] = cnt;
            }
        }

        for (int i = 0; i < 5; i++) {
            res += dp[i];
        }

        return res;
    }
}
