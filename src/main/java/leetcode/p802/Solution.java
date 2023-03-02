package leetcode.p802;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/2
 */
public class Solution {

    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();

        int[] color = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (dfs(graph, i, color)) {
                res.add(i);
            }
        }
        return res;
    }

    private boolean dfs(int[][] graph, int n, int[] color) {
        if (color[n] > 0) {
            return color[n] == 2;
        }

        color[n] = 1;
        for (int next : graph[n]) {
            if (!dfs(graph, next, color)) {
                return false;
            }
        }
        color[n] = 2;
        return true;
    }
}
