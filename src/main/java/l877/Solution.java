package l877;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/12
 */
public class Solution {

    public boolean stoneGame(int[] piles) {
        Tuple[][] dp = new Tuple[piles.length][piles.length];
        for (int i = 0; i < piles.length; i++) {
            for (int j = 0; j < piles.length; j++) {
                dp[i][j] = new Tuple(0, 0);
            }
        }
        for (int i = 0; i < piles.length; i++) {
            dp[i][i].first = piles[i];
        }

        for (int j = 1; j < piles.length; j++) {
            for (int i = j - 1; i >= 0; i--) {
                int left = piles[i] + dp[i + 1][j].second;
                int right = piles[j] + dp[i][j - 1].second;

                if (left > right) {
                    dp[i][j].first = left;
                    dp[i][j].second = dp[i + 1][j].first;
                } else {
                    dp[i][j].first = right;
                    dp[i][j].second = dp[i][j - 1].first;
                }
            }
        }

        return dp[0][piles.length - 1].first >= dp[0][piles.length - 1].second;
    }

    private class Tuple {

        private int first;

        private int second;

        public Tuple(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
