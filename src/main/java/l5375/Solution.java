package l5375;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/20
 */
public class Solution {

    public int numberOfArrays(String s, int k) {
        int[] dp = new int[s.length() + 1];
        dp[dp.length - 1] = 1;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                continue;
            }

            long n = 0;
            for (int j = i; j < s.length(); j++) {
                n = n * 10 + s.charAt(j) - '0';
                if (n <= k) {
                    dp[i] = (dp[i] + dp[j + 1]) % 1000000007;
                } else {
                    break;
                }
            }
        }

        return dp[0];
    }

    public static void main(String[] args) {
        int res = new Solution().numberOfArrays("407780786171321121429620765476840275495357129574174233567552131453038760763182952432348422252546559691171161181440370120987634895458140447952079749439961325982629462531738374032416182281868731817661954890417245087359968833257550123324827240537957646002494771036413572415"
                , 823924906);
        System.out.println(res);
    }
}
