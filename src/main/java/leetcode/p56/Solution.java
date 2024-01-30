package leetcode.p56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/30
 */
public class Solution {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            int d = Integer.compare(o1[0], o2[0]);
            if (d == 0) {
                d = Integer.compare(o1[1], o2[1]);
            }
            return d;
        });

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (list.isEmpty()) {
                list.add(intervals[i]);
            } else {
                int[] pre = list.get(list.size() - 1);
                int[] cur = intervals[i];

                if (cur[0] <= pre[1]) {
                    pre[1] = Math.max(pre[1], cur[1]);
                } else {
                    list.add(cur);
                }
            }
        }

        int[][] res = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}
