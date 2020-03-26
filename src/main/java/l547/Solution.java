package l547;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/26
 */
public class Solution {

    public int findCircleNum(int[][] M) {
        int res = 0;

        boolean[] visited = new boolean[M.length];
        for (int i = 0; i < M.length; i++) {
            if (!visited[i]) {
                dfs(M, i, visited);
                res++;
            }
        }
        return res;
    }

    private void dfs(int[][] M, int i, boolean[] visited) {
        visited[i] = true;

        for (int j = 0; j < M[i].length; j++) {
            if (M[i][j] == 1 && !visited[j]) {
                dfs(M, j, visited);
            }
        }
    }

    public static void main(String[] args) {
        new Solution().findCircleNum(new int[][]{
                new int[]{1, 0, 0},
                new int[]{0, 1, 0},
                new int[]{0, 0, 1}
        });
    }
}
