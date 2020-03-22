package l945;

import java.util.Arrays;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/22
 */
public class Solution {

    public int minIncrementForUnique(int[] A) {
        if (A.length == 0) {
            return 0;
        }

        Arrays.sort(A);

        int cur = A[0];
        int res = 0;

        for (int i = 1; i < A.length; i++) {
            int num = A[i];

            if (num > cur) {
                cur = num;
            } else {
                res += (++cur) - num;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        new Solution().minIncrementForUnique(new int[]{1, 2, 2});
    }
}
