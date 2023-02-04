package interview.p04_01;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/4
 */
public class Solution {

    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        List<Integer>[] edges = new List[n];
        for (int[] arr : graph) {
            if (edges[arr[0]] == null) {
                edges[arr[0]] = new ArrayList<>();
            }
            edges[arr[0]].add(arr[1]);
        }
        boolean[] visit = new boolean[n];
        return dfs(edges, start, target, visit);
    }

    private boolean dfs(List<Integer>[] edges, int n, int target, boolean[] visit) {
        if (n == target) {
            return true;
        }
        if (visit[n]) {
            return false;
        }
        visit[n] = true;

        List<Integer> edge = edges[n];
        if (edge != null) {
            for (int next : edge) {
                if (dfs(edges, next, target, visit)) {
                    return true;
                }
            }
        }
        return false;
    }
}
