package m01_07;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/7
 */
public class Solution {

    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int x = i;
                int y = j;

                for (int k = 1; k <= 3; k++) {
                    int x1 = n - y - 1;
                    int y1 = x;

                    swap(matrix, x, y, x1, y1);

                    x = x1;
                    y = y1;
                }
            }
        }
    }

    private void swap(int[][] matrix, int x, int y, int x1, int y1) {
        int t = matrix[x][y];
        matrix[x][y] = matrix[x1][y1];
        matrix[x1][y1] = t;
    }
}
