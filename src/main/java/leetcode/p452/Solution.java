package leetcode.p452;

import java.util.Arrays;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/29
 */
public class Solution {

    public int findMinArrowShots(int[][] points) {
        int res = 0;

        Arrays.sort(points, (o1, o2) -> {
            return Integer.compare(o1[1], o2[1]);
        });

        int pre = points[0][1];
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            if (point[0] > pre) {
                res++;
                pre = point[1];
            }
        }

        return res + 1;
    }
}
