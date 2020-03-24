package l797;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/24
 */
public class Solution {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();
        path.add(0);
        dfs(res, path, graph, 0);

        return res;
    }

    private void dfs(List<List<Integer>> res, LinkedList<Integer> path, int[][] graph, int i) {
        if (i == graph.length - 1) {
            res.add(new ArrayList<>(path));
            return;
        }

        int[] edges = graph[i];
        for (int edge : edges) {
            path.add(edge);

            dfs(res, path, graph, edge);

            path.removeLast();
        }
    }
}
