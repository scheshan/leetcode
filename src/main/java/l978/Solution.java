package l978;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/21
 */
public class Solution {

    public int maxTurbulenceSize(int[] A) {
        if (A.length < 2) {
            return A.length;
        }

        int[] dp = new int[A.length];
        dp[0] = 1;

        int res = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                dp[i] = 2;

                if (i > 1 && A[i - 1] < A[i - 2]) {
                    dp[i] = dp[i - 1] + 1;
                }
            } else if (A[i] < A[i - 1]) {
                dp[i] = 2;

                if (i > 1 && A[i - 1] > A[i - 2]) {
                    dp[i] = dp[i - 1] + 1;
                }
            } else {
                dp[i] = 1;
            }

            res = Math.max(res, dp[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        int res = new Solution().maxTurbulenceSize(new int[]{9});
        System.out.println(res);
    }
}
