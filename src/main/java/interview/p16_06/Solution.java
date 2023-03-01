package interview.p16_06;

import java.util.Arrays;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/1
 */
public class Solution {

    public int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);

        long res = Long.MAX_VALUE;
        int l = 0;
        int r = 0;
        while (l < a.length && r < b.length) {
            long n = a[l] - b[r];
            if (n < 0) {
                n = -n;
            }
            res = Math.min(res, n);
            if (a[l] < b[r]) {
                l++;
            } else {
                r++;
            }
        }

        return (int) res;
    }
}
