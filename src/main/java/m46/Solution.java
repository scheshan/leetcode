package m46;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/10
 */
public class Solution {

    public int translateNum(int num) {
        String str = String.valueOf(num);

        int[] dp = new int[str.length()];
        for (int i = str.length() - 1; i >= 0; i--) {
            if (i == str.length() - 1) {
                dp[i] = 1;
            } else {
                dp[i] = dp[i + 1];
                if (str.charAt(i) == '1' || (str.charAt(i) == '2' && str.charAt(i + 1) < '6')) {
                    if (i < str.length() - 2) {
                        dp[i] += dp[i + 2];
                    } else {
                        dp[i] += 1;
                    }
                }
            }
        }

        return dp[0];
    }
}
