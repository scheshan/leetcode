package l1094;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/5
 */
public class Solution {

    public boolean carPooling(int[][] trips, int capacity) {
        int[] count = new int[1000];
        for (int[] trip : trips) {
            count[trip[1]] += trip[0];
            count[trip[2]] -= trip[0];
        }

        int cur = 0;
        for (int n : count) {
            cur += n;
            if (cur > capacity) {
                return false;
            }
        }
        return true;
    }
}
