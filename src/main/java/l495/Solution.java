package l495;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/7
 */
public class Solution {

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int res = 0;
        int prev = -1;
        for (int time : timeSeries) {
            if (prev == -1) {
                prev = time;
            } else {
                res += Math.min(duration, time - prev);
                prev = time;
            }
        }

        if (prev > 0) {
            res += duration;
        }
        return res;
    }
}
