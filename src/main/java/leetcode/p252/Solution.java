package leetcode.p252;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/10
 */
public class Solution {

    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                return false;
            }
        }
        return true;
    }
}
