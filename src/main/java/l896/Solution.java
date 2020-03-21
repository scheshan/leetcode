package l896;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/21
 */
public class Solution {

    public boolean isMonotonic(int[] A) {
        if (A.length <= 1) {
            return true;
        }

        Boolean up = null;
        for (int i = 1; i < A.length; i++) {
            if (up != null) {
                if (up && A[i] < A[i - 1]) {
                    return false;
                }
                if (!up && A[i] > A[i - 1]) {
                    return false;
                }
            } else {
                if (A[i] != A[i - 1]) {
                    up = A[i] > A[i - 1];
                }
            }
        }

        return true;
    }
}
