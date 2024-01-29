package leetcode.p435;

import java.util.Arrays;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/29
 */
public class Solution {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            int d = Integer.compare(o1[0], o2[0]);
            if (d != 0) {
                return d;
            }
            return Integer.compare(o1[1], o2[1]);
        });

        int res = 0, pre = intervals[intervals.length - 1][0];

        for (int i = intervals.length - 2; i >= 0; i--) {
            int[] arr = intervals[i];
            if (arr[1] > pre) {
                res++;
            } else {
                pre = arr[0];
            }
        }

        return res;
    }
}
