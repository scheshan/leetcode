package l977;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/18
 */
public class Solution {

    public int[] sortedSquares(int[] A) {
        if (A == null || A.length == 0) {
            return A;
        }

        int[] result = new int[A.length];
        int mid = middle(A);

        int left = mid - 1;
        int right = mid;
        int i = 0;

        while (left >= 0 && right < A.length) {
            int l = Math.abs(A[left]);
            int r = Math.abs(A[right]);

            if (l < r) {
                result[i++] = l * l;
                left--;
            } else {
                result[i++] = r * r;
                right++;
            }
        }
        while (left >= 0) {
            result[i++] = A[left] * A[left];
            left--;
        }
        while (right < A.length) {
            result[i++] = A[right] * A[right];
            right++;
        }

        return result;
    }

    private int middle(int[] A) {
        if (A[0] > 0) {
            return 0;
        }
        for (int i = 1; i < A.length; i++) {
            if (A[i] == 0 || (A[i] > 0 && A[i - 1] < 0)) {
                return i;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        new Solution().sortedSquares(new int[]{-4, -1, 0, 3, 10});
    }
}
