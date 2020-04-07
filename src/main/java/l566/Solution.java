package l566;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/7
 */
public class Solution {

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length;
        int n = nums[0].length;

        if (r * c != m * n) {
            return nums;
        }

        int[][] res = new int[r][c];

        int row = 0;
        int col = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res[i][j] = nums[row][col];

                col++;
                if (col == n) {
                    row++;
                    col = 0;
                }
            }
        }

        return res;
    }
}
