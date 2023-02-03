package leetcode.p785;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/3
 */
public class Solution {

    public boolean isBipartite(int[][] graph) {
        int[] nodes = new int[graph.length];
        for (int i = 0; i < nodes.length; i++) {
            if(nodes[i] == 0) {
                if(!dfs(nodes, graph, i, 1)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean dfs(int[] nodes, int[][] graph, int n, int value) {
        if (nodes[n] != 0) {
            return nodes[n] == value;
        }

        nodes[n] = value;
        int[] edge = graph[n];

        for (int next : edge) {
            if (!dfs(nodes, graph, next, -value)) {
                return false;
            }
        }
        return true;
    }
}
