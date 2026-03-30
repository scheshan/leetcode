package interview.p10_01;

public class Solution {

    public void merge(int[] A, int m, int[] B, int n) {
        int ind = A.length - 1;

        while (m > 0 && n > 0) {
            if (A[m - 1] < B[n - 1]) {
                A[ind--] = B[n - 1];
                n--;
            } else {
                A[ind--] = A[m - 1];
                m--;
            }
        }

        while (m > 0) {
            A[ind--] = A[--m];
        }
        while (n > 0) {
            A[ind--] = B[--n];
        }
    }
}
