package leetcode.p973;

import java.util.Arrays;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/29
 */
public class Solution {

    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, this::compare);

        int[][] res = new int[k][];
        for (int i = 0; i < k; i++) {
            res[i] = points[i];
        }
        return res;
    }

    private int compare(int[] p1, int[] p2) {
        double d1 = Math.sqrt(Math.pow(p1[0], 2) + Math.pow(p1[1], 2));
        double d2 = Math.sqrt(Math.pow(p2[0], 2) + Math.pow(p2[1], 2));
        return Double.compare(d1, d2);
    }
}
