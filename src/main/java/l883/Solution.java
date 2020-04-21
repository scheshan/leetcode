package l883;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/21
 */
public class Solution {

    public int projectionArea(int[][] grid) {
        int[] rows = new int[grid.length];
        int[] cols = new int[grid.length];

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] > 0) {
                    count++;
                }

                rows[i] = Math.max(rows[i], grid[i][j]);
                cols[j] = Math.max(cols[j], grid[i][j]);
            }
        }

        int res = count;
        for (int i = 0; i < rows.length; i++) {
            res += rows[i];
        }
        for (int i = 0; i < cols.length; i++) {
            res += cols[i];
        }
        return res;
    }
}
