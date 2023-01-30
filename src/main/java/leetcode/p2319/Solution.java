package leetcode.p2319;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/31
 */
public class Solution {

    public boolean checkXMatrix(int[][] grid) {
        int y2 = grid[0].length - 1;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                int num = grid[row][col];
                if (row == col) {
                    if (num == 0) {
                        return false;
                    }
                } else if (row == y2 - col) {
                    if (num == 0) {
                        return false;
                    }
                } else {
                    if (num != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
