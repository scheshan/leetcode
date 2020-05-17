package l5399;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/5/17
 */
public class Solution {

    public String largestNumber(int[] cost, int target) {
        String[] dp = new String[target + 1];
        dp[0] = "";
        for (int j = 1; j <= target; j++) {
            for (int i = 0; i < cost.length; i++) {
                if (j - cost[i] >= 0) {
                    String pre = dp[j - cost[i]];
                    if (pre != null) {
                        pre += (i + 1);
                        dp[j] = max(dp[j], pre);
                    }
                }
            }
        }
        return dp[target] != null ? dp[target] : "0";
    }

    private String max(String left, String right) {
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else if (left.length() > right.length()) {
            return left;
        } else if (left.length() < right.length()) {
            return right;
        } else if (left.compareTo(right) < 0) {
            return right;
        }
        return left;
    }

    public static void main(String[] args) {
        new Solution().largestNumber(new int[]{4, 3, 2, 5, 6, 7, 2, 5, 5}, 9);
    }
}
