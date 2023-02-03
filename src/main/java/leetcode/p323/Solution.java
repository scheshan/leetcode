package leetcode.p323;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/4
 */
public class Solution {

    public int countComponents(int n, int[][] edges) {
        int[] uf = new int[n];
        for (int i = 0; i < n; i++) {
            uf[i] = i;
        }
        int res = n;

        for (int[] edge : edges) {
            if (connect(uf, edge[0], edge[1])) {
                res--;
            }
        }
        return res;
    }

    private int getParent(int[] uf, int n) {
        while (uf[n] != n) {
            uf[n] = uf[uf[n]];
            n = uf[n];
        }
        return n;
    }

    private boolean connect(int[] uf, int x, int y) {
        int p1 = getParent(uf, x);
        int p2 = getParent(uf, y);
        if (p1 == p2) {
            return false;
        }

        uf[p1] = p2;
        return true;
    }
}
