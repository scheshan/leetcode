package l309;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/21
 */
public class Solution {

    public int maxProfit(int[] prices) {
        int i0 = 0, j0 = 0, i1 = 0, j1 = 0, i2 = 0, j2 = 0;

        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                j2 = -prices[i];
            } else {
                i2 = Math.max(i1, j1 + prices[i]);
                j2 = Math.max(j1, i0 - prices[i]);
            }

            i0 = i1;
            j0 = j1;
            i1 = i2;
            j1 = j2;
        }

        return Math.max(i0, i1);
    }

    public static void main(String[] args) {
        int res = new Solution().maxProfit(new int[]{1, 2, 3, 0, 2});
        System.out.println(res);
    }
}
