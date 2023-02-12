package leetcode.p1572;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/12
 */
public class Solution {

    public int diagonalSum(int[][] mat) {
        int res = 0;
        for (int i = 0; i < mat.length; i++) {
            res += mat[i][i];
            res += mat[i][mat[i].length - i - 1];
        }

        if ((mat.length & 1) == 1) {
            int mid = (mat.length - 1) >> 1;
            res -= mat[mid][mid];
        }
        return res;
    }
}
