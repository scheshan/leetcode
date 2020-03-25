package l892;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/25
 */
public class Solution {

    public int surfaceArea(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                int n = grid[i][j];

                if (n > 0) {
                    res += 4 * n + 2;

                    if (i > 0 && grid[i - 1][j] > 0) {
                        res -= 2 * Math.min(grid[i - 1][j], n);
                    }
                    if (j > 0 && grid[i][j - 1] > 0) {
                        res -= 2 * Math.min(grid[i][j - 1], n);
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        new Solution().surfaceArea(new int[][]{
                new int[]{1, 0},
                new int[]{0, 2}
        });
    }
}
