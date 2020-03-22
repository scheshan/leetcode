package l944;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/22
 */
public class Solution {

    public int minDeletionSize(String[] A) {
        int res = 0;

        for (int col = 0; col < A[0].length(); col++) {
            for (int row = 1; row < A.length; row++) {
                if (A[row].charAt(col) < A[row - 1].charAt(col)) {
                    res++;
                    break;
                }
            }
        }

        return res;
    }
}
