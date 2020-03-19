package m08_10;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/19
 */
public class Solution {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        travel(image, sr, sc, image[sr][sc], newColor);

        return image;
    }

    private void travel(int[][] image, int i, int j, int original, int target) {
        if (i < 0 || j < 0 || i >= image.length || j >= image[i].length || image[i][j] != original || image[i][j] == target) {
            return;
        }

        image[i][j] = target;

        travel(image, i - 1, j, original, target);
        travel(image, i + 1, j, original, target);
        travel(image, i, j - 1, original, target);
        travel(image, i, j + 1, original, target);
    }

    public static void main(String[] args) {
        new Solution().floodFill(new int[][]{new int[]{0, 0, 0}, new int[]{0, 1, 1}}, 1, 1, 1);
    }
}
