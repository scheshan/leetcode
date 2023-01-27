package leetcode.p120;

import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/27
 */
public class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
        int res = Integer.MAX_VALUE;

        int[] dp = new int[triangle.get(triangle.size() - 1).size()];

        for (int row = 0; row < triangle.size(); row++) {
            List<Integer> rowData = triangle.get(row);
            for (int col = rowData.size() - 1; col >= 0; col--) {
                int num = rowData.get(col);
                if (row == 0) {
                    dp[col] = num;
                } else {
                    if (col == 0) {
                        dp[col] = dp[col] + num;
                    } else if (col == rowData.size() - 1) {
                        dp[col] = dp[col - 1] + num;
                    } else {
                        dp[col] = Math.min(dp[col], dp[col - 1]) + num;
                    }
                }
                if (row == triangle.size() - 1) {
                    res = Math.min(res, dp[col]);
                }
            }
        }
        return res;
    }
}
