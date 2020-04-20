package l1399;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/20
 */
public class Solution {

    public int countLargestGroup(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (i < 10) {
                dp[i] = i;
            } else {
                dp[i] = dp[i / 10] + dp[i % 10];
            }
        }

        int max = 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int c = map.compute(dp[i], (k, v) -> {
                if (v == null) {
                    v = 0;
                }
                return ++v;
            });
            if (c > max) {
                max = c;
                res = 1;
            } else if (c == max) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int res = new Solution().countLargestGroup(24);
        System.out.println(res);
    }
}
