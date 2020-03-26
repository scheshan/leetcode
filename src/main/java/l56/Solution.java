package l56;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/26
 */
public class Solution {

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][];
        }

        List<int[]> intervalList = new ArrayList<>(intervals.length);
        Collections.addAll(intervalList, intervals);
        intervalList.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int start = intervalList.get(0)[0];
        int end = intervalList.get(0)[1];

        List<int[]> list = new LinkedList<>();

        for (int i = 1; i < intervalList.size(); i++) {
            int[] interval = intervalList.get(i);
            if (interval[0] <= end) {
                end = Math.max(interval[1], end);
            } else {
                list.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
            }
        }

        int[][] res = new int[list.size() + 1][];
        int i = 0;
        for (int[] range : list) {
            res[i++] = range;
        }
        res[i++] = new int[]{start, end};
        return res;
    }
}
