package leetcode.p56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/11/6
 */
public class Solution {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            return o1[0] - o2[0];
        });

        List<int[]> list = new ArrayList<>(intervals.length);
        int[] tail = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] arr = intervals[i];
            if (arr[0] > tail[1]) {
                list.add(tail);
                tail = arr;
            } else {
                tail[1] = Math.max(tail[1], arr[1]);
            }
        }

        list.add(tail);

        int[][] res = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}
