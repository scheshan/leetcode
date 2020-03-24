package l52;

import java.util.Arrays;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/24
 */
public class Solution {

    public int totalNQueens(int n) {
        char[][] grid = new char[n][n];
        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(grid[i], '.');
        }

        int res = perm(grid, 0, n);

        return res;
    }

    private int perm(char[][] grid, int i, int n) {
        if (i == n) {
            return 1;
        }

        int res = 0;
        for (int j = 0; j < n; j++) {
            boolean canPlace = true;
            for (int k = 0; k < i; k++) {
                if (grid[k][j] == 'Q') {
                    canPlace = false;
                    break;
                }
                int right = j + i - k;
                int left = j - i + k;
                if (left >= 0 && grid[k][left] == 'Q') {
                    canPlace = false;
                    break;
                }
                if (right < n && grid[k][right] == 'Q') {
                    canPlace = false;
                    break;
                }
            }

            if (canPlace) {
                grid[i][j] = 'Q';
                res += perm(grid, i + 1, n);
                grid[i][j] = '.';
            }
        }
        return res;
    }
}
