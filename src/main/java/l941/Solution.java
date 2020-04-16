package l941;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/16
 */
public class Solution {

    public boolean validMountainArray(int[] A) {
        if (A.length < 3) {
            return false;
        }

        int i = 0;
        while (i < A.length - 1 && A[i + 1] > A[i]) {
            i++;
        }
        if (i == 0 || i == A.length - 1) {
            return false;
        }
        i++;
        while (i < A.length) {
            if (A[i] >= A[i - 1]) {
                return false;
            }
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        new Solution().validMountainArray(new int[]{0, 3, 2, 1});
    }
}
