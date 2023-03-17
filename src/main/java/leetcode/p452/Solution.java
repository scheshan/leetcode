package leetcode.p452;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/16
 */
public class Solution {

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));

        int res = 1;
        int[] pre = points[0];
        for (int i = 1; i < points.length; i++) {
            int[] point = points[i];

            if (point[0] > pre[1]) {
                res++;
                pre = point;
            } else {
                pre[0] = Math.max(pre[0], point[0]);
                pre[1] = Math.min(pre[1], point[1]);
            }
        }

        return res;
    }
}
