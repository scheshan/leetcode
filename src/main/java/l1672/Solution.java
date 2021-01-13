package l1672;

/**
 * Solution
 *
 * @author heshan
 * @date 2021/1/13
 */
public class Solution {

    public int maximumWealth(int[][] accounts) {
        int res = 0;

        int cur = 0;
        for (int i = 0; i < accounts.length; i++) {
            cur = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                cur += accounts[i][j];
            }
            res = Math.max(res, cur);
        }

        return res;
    }
}
