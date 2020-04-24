package l302;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/24
 */
public class Solution {

    private int x1, x2, y1, y2;

    public int minArea(char[][] image, int x, int y) {
        if (image.length == 0) {
            return 0;
        }

        x1 = Integer.MAX_VALUE;
        x2 = Integer.MIN_VALUE;
        y1 = Integer.MAX_VALUE;
        y2 = Integer.MIN_VALUE;

        dfs(image, x, y);

        int row = x2 - x1 + 1;
        int col = y2 - y1 + 1;
        return row * col;
    }

    private void dfs(char[][] image, int i, int j) {
        if (i < 0 || j < 0 || i >= image.length || j >= image[i].length || image[i][j] != '1') {
            return;
        }

        image[i][j] = '0';
        x1 = Math.min(x1, i);
        x2 = Math.max(x2, i);
        y1 = Math.min(y1, j);
        y2 = Math.max(y2, j);

        dfs(image, i - 1, j);
        dfs(image, i + 1, j);
        dfs(image, i, j - 1);
        dfs(image, i, j + 1);
    }
}
