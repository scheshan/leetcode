package m01_05;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/22
 */
public class Solution {

    public boolean oneEditAway(String first, String second) {
        if (first.equals(second)) {
            return true;
        } else if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }

        int[][] dp = new int[first.length() + 1][second.length() + 1];
        for (int i = 1; i <= first.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= second.length(); i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= first.length(); i++) {
            for (int j = 1; j <= second.length(); j++) {
                if (first.charAt(i - 1) == second.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int n = Math.min(dp[i - 1][j - 1] + 1, dp[i - 1][j] + 1);
                    n = Math.min(n, dp[i][j - 1] + 1);
                    dp[i][j] = n;
                }
            }
        }

        return dp[first.length()][second.length()] <= 1;
    }

    public static void main(String[] args) {
        boolean res = new Solution().oneEditAway("intention", "execution");
        System.out.println(res);
    }
}
