package leetcode.p986;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/22
 */
public class Solution {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> list = new ArrayList<>();

        int l = 0;
        int r = 0;
        while (l < firstList.length && r < secondList.length) {
            int[] left = firstList[l];
            int[] right = secondList[r];

            if (left[1] < right[0]) {
                l++;
            } else if (right[1] < left[0]) {
                r++;
            } else if (left[1] < right[1]) {
                list.add(new int[]{Math.max(left[0], right[0]), left[1]});
                l++;
            } else {
                list.add(new int[]{Math.max(left[0], right[0]), right[1]});
                r++;
            }
        }

        int[][] res = new int[list.size()][];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
