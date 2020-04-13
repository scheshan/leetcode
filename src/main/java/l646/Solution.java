package l646;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/13
 */
public class Solution {

    public int findLongestChain(int[][] pairs) {
        if (pairs.length == 0) {
            return 0;
        }

        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int[] dp = new int[pairs.length];

        int res = 0;
        for (int i = 0; i < pairs.length; i++) {
            dp[i] = 0;
            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    res = Math.max(res, dp[i]);
                }
            }
        }

        return res;
    }
}
