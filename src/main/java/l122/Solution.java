package l122;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/24
 */
public class Solution {

    public int maxProfit(int[] prices) {
        int res = 0;

        if (prices.length < 2) {
            return res;
        }

        boolean up = true;
        int min = prices[0];
        int max = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (!up) {
                if (prices[i] <= prices[i - 1]) {
                    min = prices[i];
                } else {
                    up = true;
                    max = prices[i];
                }
            } else {
                if (prices[i] >= prices[i - 1]) {
                    max = prices[i];
                } else {
                    up = false;
                    res += Math.max(0, max - min);
                    min = prices[i];
                }
            }
        }

        if (up) {
            res += Math.max(0, max - min);
        }

        return res;
    }

    public static void main(String[] args) {
        new Solution().maxProfit(new int[]{7, 1, 5, 3, 6, 4});
    }
}
