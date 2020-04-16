package l840;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/16
 */
public class Solution {

    public int numMagicSquaresInside(int[][] grid) {
        int res = 0;

        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid[i].length - 2; j++) {
                if (match(grid, i, j)) {
                    res++;
                }
            }
        }

        return res;
    }

    private boolean match(int[][] grid, int x1, int y1) {
        boolean[] set = new boolean[10];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int n = grid[x1 + i][y1 + j];
                if (n >= 10 || n <= 0 || set[n]) {
                    return false;
                }
                set[n] = true;
            }
        }

        int target = grid[x1][y1] + grid[x1 + 1][y1] + grid[x1 + 2][y1];

        if (target != grid[x1][y1] + grid[x1][y1 + 1] + grid[x1][y1 + 2]) {
            return false;
        }
        if (target != grid[x1 + 2][y1] + grid[x1 + 2][y1 + 1] + grid[x1 + 2][y1 + 2]) {
            return false;
        }
        if (target != grid[x1][y1] + grid[x1 + 1][y1 + 1] + grid[x1 + 2][y1 + 2]) {
            return false;
        }
        if (target != grid[x1][y1 + 2] + grid[x1 + 1][y1 + 1] + grid[x1 + 2][y1]) {
            return false;
        }
        if (target != grid[x1][y1 + 2] + grid[x1 + 1][y1 + 2] + grid[x1 + 2][y1 + 2]) {
            return false;
        }

        return true;
    }
}
