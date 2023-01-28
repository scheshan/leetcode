package leetcode.p797;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/28
 */
public class Solution {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(graph, 0, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[][] graph, int ind, ArrayList<Integer> path, List<List<Integer>> res) {
        path.add(ind);
        if (ind == graph.length - 1) {
            res.add(new ArrayList<>(path));
        } else {
            for (int next : graph[ind]) {
                dfs(graph, next, path, res);
            }
        }
        path.remove(path.size() - 1);
    }
}
