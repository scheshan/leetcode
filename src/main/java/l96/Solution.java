package l96;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/25
 */
public class Solution {

    public int numTrees(int n) {
        int[][] dp = new int[n + 1][n + 1];

        int res = count(1, n, dp);
        return res;
    }

    private int count(int min, int max, int[][] dp) {
        if (min > max) {
            return 1;
        }

        if (dp[min][max] > 0) {
            return dp[min][max];
        }

        int res = 0;
        for (int i = min; i <= max; i++) {
            int left = count(min, i - 1, dp);
            int right = count(i + 1, max, dp);
            res += left * right;
        }
        dp[min][max] = res;
        return res;
    }

    public static void main(String[] args) {
        int res = new Solution().numTrees(10);
        System.out.println(res);
    }
}
