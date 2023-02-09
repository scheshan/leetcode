package leetcode.p57;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/9
 */
public class Solution {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>(intervals.length);
        list.add(newInterval);

        for (int[] arr : intervals) {
            int[] last = list.get(list.size() - 1);
            if (arr[1] < last[0]) {
                list.set(list.size() - 1, arr);
                list.add(last);
            } else if (arr[0] > last[1]) {
                list.add(arr);
            } else {
                last[0] = Math.min(last[0], arr[0]);
                last[1] = Math.max(last[1], arr[1]);
            }
        }

        int[][] res = new int[list.size()][];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
