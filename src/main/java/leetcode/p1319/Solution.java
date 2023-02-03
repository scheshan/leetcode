package leetcode.p1319;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/4
 */
public class Solution {

    public int makeConnected(int n, int[][] connections) {
        int[] uf = new int[n];
        for (int i = 0; i < n; i++) {
            uf[i] = i;
        }
        int total = n;
        int redundant = 0;

        for (int[] conn : connections) {
            if (connect(uf, conn[0], conn[1])) {
                total--;
            } else {
                redundant++;
            }
        }

        if (redundant >= total - 1) {
            return total - 1;
        }
        return -1;
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

        uf[p1] = uf[p2];
        return true;
    }
}
