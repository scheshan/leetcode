package leetcode.p1135;

import java.util.Arrays;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/18
 */
public class Solution {

    public int minimumCost(int n, int[][] connections) {
        Arrays.sort(connections, (o1, o2) -> Integer.compare(o1[2], o2[2]));
        int[] uf = new int[n];
        for (int i = 0; i < n; i++) {
            uf[i] = i;
        }
        int res = 0;
        int components = n;
        for (int[] conn : connections) {
            if (connect(uf, conn[0] - 1, conn[1] - 1)) {
                components--;
                res += conn[2];
            }
        }

        if(components == 1) {
            return res;
        }
        return -1;
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
