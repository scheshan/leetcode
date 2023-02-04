package interview.p08_02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/4
 */
public class Solution {

    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        List<List<Integer>> res = new ArrayList<>();
        if (dfs(obstacleGrid, 0, 0, res)) {
            return res;
        }
        return new ArrayList<>();
    }

    private boolean dfs(int[][] grid, int row, int col, List<List<Integer>> path) {
        path.add(Arrays.asList(row, col));
        if (grid[row][col] == 0) {
            if (row == grid.length - 1 && col == grid[row].length - 1) {
                return true;
            }

            grid[row][col] = 1;
            if (row < grid.length - 1 && dfs(grid, row + 1, col, path)) {
                return true;
            }
            if (col < grid[row].length - 1 && dfs(grid, row, col + 1, path)) {
                return true;
            }
        }
        path.remove(path.size() - 1);
        return false;
    }
}
