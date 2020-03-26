package l1020;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/26
 */
public class Solution {

    public int numEnclaves(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            dfs(A, i, 0);
            dfs(A, i, A[i].length - 1);
        }
        for (int j = 1; j < A[0].length - 1; j++) {
            dfs(A, 0, j);
        }
        for (int j = 1; j < A[A.length - 1].length - 1; j++) {
            dfs(A, A.length - 1, j);
        }

        int res = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                if (A[i][j] == 1) {
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(int[][] A, int i, int j) {
        if (i < 0 || j < 0 || i >= A.length || j >= A[i].length || A[i][j] != 1) {
            return;
        }

        A[i][j] = -1;
        dfs(A, i + 1, j);
        dfs(A, i - 1, j);
        dfs(A, i, j - 1);
        dfs(A, i, j + 1);
    }
}
