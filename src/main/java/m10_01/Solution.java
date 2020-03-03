package m10_01;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/3
 */
public class Solution {

    public void merge(int[] A, int m, int[] B, int n) {
        int i = m + n - 1;

        m--;
        n--;

        while (m >= 0 && n >= 0) {
            if (A[m] >= B[n]) {
                A[i--] = A[m];
                m--;
            } else {
                A[i--] = B[n];
                n--;
            }
        }

        while (m >= 0) {
            A[i--] = A[m--];
        }
        while (n >= 0) {
            A[i--] = B[n--];
        }
    }
}
