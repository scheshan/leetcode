package interview.p10_01;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/18
 */
public class Solution {

    public void merge(int[] A, int m, int[] B, int n) {
        int ind = A.length - 1;
        m--;
        n--;
        while (m >= 0 && n >= 0) {
            if (A[m] > B[n]) {
                A[ind--] = A[m--];
            } else {
                A[ind--] = B[n--];
            }
        }
        while (m >= 0) {
            A[ind--] = A[m--];
        }
        while (n >= 0) {
            A[ind--] = B[n--];
        }
    }
}
