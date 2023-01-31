package interview.p13;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/1
 */
public class Solution {

    public int movingCount(int m, int n, int k) {
        boolean[][] visit = new boolean[m][n];
        return dfs(visit, 0, 0, k);
    }

    private int dfs(boolean[][] visit, int row, int col, int k) {
        if (visit[row][col] || sum(row) + sum(col) > k) {
            return 0;
        }

        visit[row][col] = true;
        int res = 1;
        if (row > 0) {
            res += dfs(visit, row - 1, col, k);
        }
        if (row < visit.length - 1) {
            res += dfs(visit, row + 1, col, k);
        }
        if (col > 0) {
            res += dfs(visit, row, col - 1, k);
        }
        if (col < visit[row].length - 1) {
            res += dfs(visit, row, col + 1, k);
        }
        return res;
    }

    private int sum(int num) {
        int res = 0;
        while (num > 0) {
            res += num % 10;
            num /= 10;
        }
        return res;
    }
}
