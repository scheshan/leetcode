package l62;

import java.util.Arrays;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/28
 */
public class Solution {

    public int uniquePaths(int m, int n) {
        int[] row = new int[n];
        Arrays.fill(row, 1);

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                row[j] = row[j - 1] + row[j];
            }
        }

        return row[n - 1];
    }

    public static void main(String[] args) {
        new Solution().uniquePaths(3, 2);
    }
}
