package leetcode.p121;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/26
 */
public class Solution {

    public int maxProfit(int[] prices) {
        int res = 0;
        int low = prices[0];

        for (int i = 1; i < prices.length; i++) {
            res = Math.max(res, prices[i] - low);
            low = Math.min(low, prices[i]);
        }

        return res;
    }
}
