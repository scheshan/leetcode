package l832;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/22
 */
public class Solution {

    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            int l = 0;
            int r = A[i].length - 1;

            while (l <= r) {
                int t = A[i][l];
                A[i][l] = 1 - A[i][r];
                A[i][r] = 1 - t;

                l++;
                r--;
            }
        }

        return A;
    }
}
