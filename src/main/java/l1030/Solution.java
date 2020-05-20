package l1030;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/5/20
 */
public class Solution {

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int bucketSize = Math.max(r0, R - 1 - r0) + Math.max(c0, C - 1 - c0);
        LinkedList<int[]>[] buckets = new LinkedList[bucketSize + 1];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int d = Math.abs(i - r0) + Math.abs(j - c0);

                LinkedList<int[]> list = buckets[d];
                if (list == null) {
                    list = new LinkedList<>();
                    buckets[d] = list;
                }

                list.add(new int[]{i, j});
            }
        }

        int[][] res = new int[R * C][];
        int i = 0;
        for (int j = 0; j < buckets.length; j++) {
            LinkedList<int[]> list = buckets[j];
            if (list != null) {
                while (!list.isEmpty()) {
                    res[i++] = list.removeFirst();
                }
            }
        }
        return res;
    }
}
