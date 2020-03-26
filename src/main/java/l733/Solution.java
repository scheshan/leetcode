package l733;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/26
 */
public class Solution {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        dfs(image, sr, sc, image[sr][sc], newColor);

        return image;
    }

    private void dfs(int[][] image, int i, int j, int original, int newColor) {
        if (i < 0 || j < 0 || i >= image.length || j >= image[i].length || image[i][j] != original || image[i][j] == newColor) {
            return;
        }

        image[i][j] = newColor;

        dfs(image, i - 1, j, original, newColor);
        dfs(image, i + 1, j, original, newColor);
        dfs(image, i, j - 1, original, newColor);
        dfs(image, i, j + 1, original, newColor);
    }

    public static void main(String[] args) {
        new Solution().floodFill(new int[][]{
                        new int[]{0, 0, 0},
                        new int[]{0, 1, 1}},
                1,
                1,
                1);
    }
}
