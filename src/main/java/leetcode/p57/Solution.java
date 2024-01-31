package leetcode.p57;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/2/1
 */
public class Solution {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>(intervals.length + 1);
        for (int i = 0; i < intervals.length; i++) {
            list.add(intervals[i]);
        }
        list.add(newInterval);

        list.sort((o1, o2) -> {
            int d = Integer.compare(o1[0], o2[0]);
            if (d == 0) Integer.compare(o1[1], o2[1]);
            return d;
        });

        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int[] cur = list.get(i);
            if (res.isEmpty()) {
                res.add(cur);
            } else {
                int[] pre = res.get(res.size() - 1);
                if (cur[0] <= pre[1]) {
                    pre[1] = Math.max(pre[1], cur[1]);
                } else {
                    res.add(cur);
                }
            }
        }

        int[][] arr = new int[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }

        return arr;
    }
}
