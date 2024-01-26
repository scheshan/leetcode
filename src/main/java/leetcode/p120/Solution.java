package leetcode.p120;

import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/26
 */
public class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
        int res = Integer.MAX_VALUE;
        int[] dp = new int[triangle.get(triangle.size() - 1).size()];

        for (int i = 0; i < triangle.size(); i++) {
            List<Integer> list = triangle.get(i);
            for (int j = list.size() - 1; j >= 0; j--) {
                if (i == 0) {
                    dp[j] = list.get(j);
                } else {
                    if (j == 0) {
                        dp[j] += list.get(j);
                    } else if (j == list.size() - 1) {
                        dp[j] = dp[j - 1] + list.get(j);
                    } else {
                        dp[j] = Math.min(dp[j], dp[j - 1]) + list.get(j);
                    }
                }
            }
        }

        for (int num : dp) {
            res = Math.min(res, num);
        }

        return res;
    }
}
