package offer2.p074;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/27
 */
public class Solution {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> list = new ArrayList<>();

        for (int[] interval : intervals) {
            if (list.size() > 0 && interval[0] <= list.get(list.size() - 1)[1]) {
                int[] pre = list.get(list.size() - 1);
                if (interval[0] <= pre[1]) {
                    pre[1] = Math.max(interval[1], pre[1]);
                }
            } else {
                list.add(interval);
            }
        }
        int[][] res = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
