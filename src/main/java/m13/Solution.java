package m13;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/8
 */
public class Solution {

    public int movingCount(int m, int n, int k) {
        int[] count = new int[101];
        count[100] = 1;

        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) {
                    count[i] = i;
                } else {
                    count[j * 10 + i] = j + count[i];
                }
            }
        }

        int[][] dp = new int[m][n];

        return dfs(dp, 0, 0, count, k);
    }

    private int dfs(int[][] grid, int i, int j, int[] count, int k) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] != 0) {
            return 0;
        }

        grid[i][j] = 1;

        int res = 0;
        int c = count[i] + count[j];
        if (c <= k) {
            res++;

            res += dfs(grid, i - 1, j, count, k);
            res += dfs(grid, i + 1, j, count, k);
            res += dfs(grid, i, j - 1, count, k);
            res += dfs(grid, i, j + 1, count, k);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("result:" + new Solution().movingCount(16, 8, 4));
    }
}
