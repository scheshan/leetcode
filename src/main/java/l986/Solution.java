package l986;

import java.util.LinkedList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/29
 */
public class Solution {

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> list = new LinkedList<>();

        int l = 0;
        int r = 0;

        while (l < A.length && r < B.length) {
            int[] a = A[l];
            int[] b = B[r];

            if (a[1] < b[0]) {
                l++;
            } else if (b[1] < a[0]) {
                r++;
            } else {
                list.add(new int[]{Math.max(a[0], b[0]), Math.min(a[1], b[1])});
                if (a[1] >= b[1]) {
                    r++;
                } else {
                    l++;
                }
            }
        }

        int[][] res = new int[list.size()][];
        int i = 0;
        for (int[] item : list) {
            res[i++] = item;
        }

        return res;
    }
}
