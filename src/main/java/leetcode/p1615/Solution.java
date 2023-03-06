package leetcode.p1615;

import java.util.HashSet;
import java.util.Set;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/7
 */
public class Solution {

    public int maximalNetworkRank(int n, int[][] roads) {
        Set<Integer>[] edges = new Set[n];
        for (int i = 0; i < n; i++) {
            edges[i] = new HashSet<>();
        }
        for (int[] road : roads) {
            edges[road[0]].add(road[1]);
            edges[road[1]].add(road[0]);
        }

        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int cnt = edges[i].size() + edges[j].size();
                if (edges[i].contains(j)) {
                    cnt--;
                }
                res = Math.max(res, cnt);
            }
        }
        return res;
    }
}
