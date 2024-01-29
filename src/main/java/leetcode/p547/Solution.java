package leetcode.p547;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/29
 */
public class Solution {

    public int findCircleNum(int[][] isConnected) {
        int res = 0;
        boolean[] visit = new boolean[isConnected.length];

        for (int i = 0; i < isConnected.length; i++) {
            if (!visit[i]) {
                res++;
                dfs(isConnected, i, visit);
            }
        }

        return res;
    }

    private void dfs(int[][] edges, int i, boolean[] visit) {
        if (visit[i]) {
            return;
        }

        visit[i] = true;

        for (int j = 0; j < edges[i].length; j++) {
            if (edges[i][j] == 1) {
                dfs(edges, j, visit);
            }
        }
    }
}
