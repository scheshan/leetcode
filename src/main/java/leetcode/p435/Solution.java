package leetcode.p435;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/1
 */
public class Solution {

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 1) {
            return 1;
        }

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int right = intervals[0][1];
        int cnt = 1;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= right) {
                cnt++;
                right = intervals[i][1];
            }
        }

        return intervals.length - cnt;
    }
}
