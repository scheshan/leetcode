package l743;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/5/19
 */
public class Solution {

    public int networkDelayTime(int[][] times, int N, int K) {
        List<int[]>[] edges = new List[N];
        for (int[] time : times) {
            List<int[]> list = edges[time[0] - 1];
            if (list == null) {
                list = new LinkedList<>();
                edges[time[0] - 1] = list;
            }
            list.add(time);
        }

        int[] nodes = new int[N];
        Arrays.fill(nodes, Integer.MAX_VALUE);
        dfs(nodes, K, 1, edges);

        int res = 0;
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] == Integer.MAX_VALUE) {
                return -1;
            }
            res = Math.max(res, nodes[i]);
        }
        return res - 1;
    }

    private void dfs(int[] nodes, int n, int time, List<int[]>[] edges) {
        if (nodes[n - 1] <= time) {
            return;
        }

        nodes[n - 1] = time;
        List<int[]> edge = edges[n - 1];
        if (edge == null) {
            return;
        }

        for (int[] e : edge) {
            dfs(nodes, e[1], time + e[2], edges);
        }
    }
}
