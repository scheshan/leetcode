package leetcode.p1030;

import java.util.Arrays;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/14
 */
public class Solution {

    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int[][] res = new int[rows * cols][2];
        int ind = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                res[ind][0] = i;
                res[ind][1] = j;
                ind++;
            }
        }

        Arrays.sort(res, (o1, o2) -> {
            int d1 = Math.abs(rCenter - o1[0]) + Math.abs(cCenter - o1[1]);
            int d2 = Math.abs(rCenter - o2[0]) + Math.abs(cCenter - o2[1]);
            return Integer.compare(d1, d2);
        });

        return res;
    }
}
