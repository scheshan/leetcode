package l1351;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/21
 */
public class Solution {

    public int countNegatives(int[][] grid) {
        int i = 0;
        int j = grid[i].length - 1;

        int result = 0;

        while (i < grid.length && j >= 0) {
            if (grid[i][j] >= 0) {
                i++;
            } else {
                result += grid.length - i;
                j--;
            }
        }
        return result;
    }
}
