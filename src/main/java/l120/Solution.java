package l120;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/10
 */
public class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()];

        int res = Integer.MAX_VALUE;

        for (int i = 0; i < triangle.size(); i++) {
            for (int j = triangle.get(i).size() - 1; j >= 0; j--) {
                if (i == 0) {
                    dp[j] = triangle.get(i).get(j);
                } else {
                    if (j == 0) {
                        dp[j] = dp[j] + triangle.get(i).get(j);
                    } else if (j == triangle.get(i).size() - 1) {
                        dp[j] = triangle.get(i).get(j) + dp[i - 1];
                    } else {
                        dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j - 1]);
                    }
                }

                if (i == triangle.size() - 1) {
                    res = Math.min(res, dp[j]);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));

        new Solution().minimumTotal(triangle);
    }
}
