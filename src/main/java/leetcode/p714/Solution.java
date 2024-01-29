package leetcode.p714;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/29
 */
public class Solution {

    public int maxProfit(int[] prices, int fee) {
        int have = -prices[0], notHave = 0;

        for (int i = 1; i < prices.length; i++) {
            int h = Math.max(have, notHave - prices[i]);
            int nh = Math.max(notHave, have + prices[i] - fee);

            have = h;
            notHave = nh;
        }

        return Math.max(have, notHave);
    }
}
