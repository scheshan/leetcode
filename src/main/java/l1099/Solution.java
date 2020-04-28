package l1099;

import java.util.Arrays;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/26
 */
public class Solution {

    public int twoSumLessThanK(int[] A, int K) {
        Arrays.sort(A);

        int res = -1;
        int left = 0;
        int right = A.length - 1;
        while (left < right) {
            int sum = A[left] + A[right];
            if (sum < K) {
                res = Math.max(res, sum);
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}
