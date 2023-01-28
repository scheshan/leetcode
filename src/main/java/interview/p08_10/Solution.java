package interview.p08_10;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/28
 */
public class Solution {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] != color) {
            dfs(image, sr, sc, image[sr][sc], color);
        }
        return image;
    }

    private void dfs(int[][] image, int row, int col, int color0, int color) {
        if (image[row][col] != color0) {
            return;
        }

        image[row][col] = color;
        if (row > 0) {
            dfs(image, row - 1, col, color0, color);
        }
        if (row < image.length - 1) {
            dfs(image, row + 1, col, color0, color);
        }
        if (col > 0) {
            dfs(image, row, col - 1, color0, color);
        }
        if (col < image[row].length - 1) {
            dfs(image, row, col + 1, color0, color);
        }
    }
}
