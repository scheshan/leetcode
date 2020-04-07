package l1109;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/7
 */
public class Solution {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] prefix = new int[n + 1];
        for (int[] b : bookings) {
            prefix[b[0]] += b[2];
            if (b[1] < prefix.length - 1) {
                prefix[b[1] + 1] -= b[2];
            }
        }

        int[] res = new int[n];
        int cur = 0;
        for (int i = 0; i < n; i++) {
            cur += prefix[i + 1];
            res[i] = cur;
        }

        return res;
    }
}
