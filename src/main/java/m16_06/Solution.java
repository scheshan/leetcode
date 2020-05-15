package m16_06;

import java.util.Arrays;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/5/15
 */
public class Solution {

    public int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);

        int l = 0;
        int r = 0;
        long result = Long.MAX_VALUE;

        while (l < a.length && r < b.length) {
            result = Math.min(result, Math.abs((long) a[l] - (long) b[r]));

            if (a[l] < b[r]) {
                l++;
            } else {
                r++;
            }
        }

        return (int)result;
    }
}
