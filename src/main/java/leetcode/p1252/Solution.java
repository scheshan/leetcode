package leetcode.p1252;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/26
 */
public class Solution {

    public int oddCells(int m, int n, int[][] indices) {
        int[] rows = new int[m];
        int[] cols = new int[n];

        for (int[] indice : indices) {
            rows[indice[0]]++;
            cols[indice[1]]++;
        }

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int num = rows[i] + cols[j];
                res += num & 1;
            }
        }
        return res;
    }
}
