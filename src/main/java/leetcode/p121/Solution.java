package leetcode.p121;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/29
 */
public class Solution {

    public int maxProfit(int[] prices) {
        int res = 0, pre = prices[0];

        for (int i = 1; i < prices.length; i++) {
            res = Math.max(res, prices[i] - pre);
            pre = Math.min(pre, prices[i]);
        }

        return res;
    }
}
