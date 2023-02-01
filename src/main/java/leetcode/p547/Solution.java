package leetcode.p547;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/1
 */
public class Solution {

    public int findCircleNum(int[][] isConnected) {
        int[] uf = new int[isConnected.length];
        for (int i = 0; i < uf.length; i++) {
            uf[i] = i;
        }

        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[i].length; j++) {
                if (i != j && isConnected[i][j] == 1) {
                    connect(uf, i, j);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < uf.length; i++) {
            if (uf[i] == i) {
                res++;
            }
        }
        return res;
    }

    private void connect(int[] uf, int i, int j) {
        int p1 = getParent(uf, i);
        int p2 = getParent(uf, j);

        if (p1 != p2) {
            uf[p1] = p2;
        }
    }

    private int getParent(int[] uf, int i) {
        while (i != uf[i]) {
            uf[i] = uf[uf[i]];
            i = uf[i];
        }
        return i;
    }
}
