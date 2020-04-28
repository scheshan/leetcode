package m04_01;

import java.util.LinkedList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/28
 */
public class Solution {

    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        if (n == 0) {
            return false;
        }

        boolean[] visited = new boolean[n];
        List<Integer>[] edges = new List[n];

        for (int[] g : graph) {
            if (edges[g[0]] == null) {
                edges[g[0]] = new LinkedList<>();
            }
            edges[g[0]].add(g[1]);
        }

        return dfs(edges, visited, start, target);
    }

    private boolean dfs(List<Integer>[] edges, boolean[] visited, int n, int target) {
        if (visited[n]) {
            return false;
        }

        if (n == target) {
            return true;
        }

        visited[n] = true;
        List<Integer> edge = edges[n];
        boolean res = false;

        if (edge != null) {
            for (int e : edge) {
                res = res || dfs(edges, visited, e, target);
            }
        }
        return res;
    }
}
