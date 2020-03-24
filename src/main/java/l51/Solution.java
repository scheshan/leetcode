package l51;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/24
 */
public class Solution {

    public List<List<String>> solveNQueens(int n) {
        char[][] grid = new char[n][n];
        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(grid[i], '.');
        }

        List<List<String>> res = new LinkedList<>();
        perm(res, grid, 0, n);

        return res;
    }

    private void perm(List<List<String>> res, char[][] grid, int i, int n) {
        if (i == n) {
            res.add(transfer(grid));
            return;
        }

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
                perm(res, grid, i + 1, n);
                grid[i][j] = '.';
            }
        }
    }

    private List<String> transfer(char[][] grid) {
        List<String> res = new ArrayList<>(grid.length);
        for(char[] row : grid){
            res.add(new String(row));
        }

        return res;
    }

    public static void main(String[] args) {
        new Solution().solveNQueens(4);
    }
}
