package leetcode.p1584;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/18
 */
public class Solution {

    public int minCostConnectPoints(int[][] points) {
        List<int[]> edges = new ArrayList<>(points.length * points.length);
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }

                int dis = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                edges.add(new int[]{i, j, dis});
            }
        }
        edges.sort((o1, o2) -> Integer.compare(o1[2], o2[2]));

        int[] uf = new int[points.length];
        for (int i = 0; i < uf.length; i++) {
            uf[i] = i;
        }
        int total = points.length;
        int res = 0;

        for (int i = 0; i < edges.size(); i++) {
            int[] edge = edges.get(i);
            if (connect(uf, edge[0], edge[1])) {
                res += edge[2];
                total--;
            }
            if (total == 1) {
                break;
            }
        }
        return res;
    }

    private int getParent(int[] uf, int i) {
        while (i != uf[i]) {
            uf[i] = uf[uf[i]];
            i = uf[i];
        }
        return i;
    }

    private boolean connect(int[] uf, int i, int j) {
        int p1 = getParent(uf, i);
        int p2 = getParent(uf, j);
        if (p1 != p2) {
            uf[p1] = p2;
            return true;
        }
        return false;
    }
}
