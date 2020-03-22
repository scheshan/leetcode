package l1252;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/22
 */
public class Solution {

    public int oddCells(int n, int m, int[][] indices) {
        int[][] grid = new int[n][m];

        for (int[] ind : indices) {
            for (int i = 0; i < n; i++) {
                grid[i][ind[1]]++;
            }
            for (int i = 0; i < m; i++) {
                grid[ind[0]][i]++;
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((grid[i][j] & 1) == 1) {
                    res++;
                }
            }
        }

        return res;
    }
}
