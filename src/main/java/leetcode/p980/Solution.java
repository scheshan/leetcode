package leetcode.p980;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/28
 */
public class Solution {

    public int uniquePathsIII(int[][] grid) {
        int startRow = 0;
        int startCol = 0;
        int totalZero = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 1) {
                    startRow = row;
                    startCol = col;
                } else if (grid[row][col] == 0) {
                    totalZero++;
                }
            }
        }
        return perm(grid, startRow, startCol, totalZero);
    }

    private int perm(int[][] grid, int row, int col, int total) {
        if (grid[row][col] == 2) {
            return total == 0 ? 1 : 0;
        }
        if (grid[row][col] == -1) {
            return 0;
        }

        if (grid[row][col] == 0) {
            total--;
        }
        grid[row][col] = -1;
        int res = 0;
        if (row > 0) {
            res += perm(grid, row - 1, col, total);
        }
        if (row < grid.length - 1) {
            res += perm(grid, row + 1, col, total);
        }
        if (col > 0) {
            res += perm(grid, row, col - 1, total);
        }
        if (col < grid[row].length - 1) {
            res += perm(grid, row, col + 1, total);
        }
        grid[row][col] = 0;
        return res;
    }
}
