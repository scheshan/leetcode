package offer.p63;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/18
 */
public class Solution {

    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int res = 0;

        for (int price : prices) {
            if (price < min) {
                min = price;
            } else {
                res = Math.max(res, price - min);
            }
        }

        return res;
    }
}
