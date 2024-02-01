package leetcode.p1466;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/2/1
 */
public class Solution {

    public int minReorder(int n, int[][] connections) {
        List<int[]>[] edges = new List[n];

        for (int[] conn : connections) {
            getEdge(edges, conn[0]).add(new int[]{conn[1], 1});
            getEdge(edges, conn[1]).add(new int[]{conn[0], 0});
        }

        boolean[] visit = new boolean[n];
        return dfs(0, edges, visit);
    }

    private int dfs(int n, List<int[]>[] edges, boolean[] visit) {
        if (visit[n]) {
            return 0;
        }
        visit[n] = true;

        int res = 0;
        List<int[]> edge = getEdge(edges, n);
        for (int[] next : edge) {
            if (visit[next[0]]) {
                continue;
            }
            res += dfs(next[0], edges, visit) + next[1];
        }
        return res;
    }

    private List<int[]> getEdge(List<int[]>[] edges, int ind) {
        if (edges[ind] == null) {
            edges[ind] = new ArrayList<>();
        }
        return edges[ind];
    }
}
