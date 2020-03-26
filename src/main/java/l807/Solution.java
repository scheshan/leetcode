package l807;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/26
 */
public class Solution {

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] rows = new int[grid.length];
        int[] cols = new int[grid.length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                rows[i] = Math.max(rows[i], grid[i][j]);
                cols[j] = Math.max(cols[j], grid[i][j]);
            }
        }

        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int min = Math.min(cols[j], rows[i]);
                if (min != grid[i][j]) {
                    res += min - grid[i][j];
                }
            }
        }

        return res;
    }
}
