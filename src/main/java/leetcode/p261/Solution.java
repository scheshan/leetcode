package leetcode.p261;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/13
 */
public class Solution {

    public boolean validTree(int n, int[][] edges) {
        int[] uf = new int[n];
        for (int i = 0; i < n; i++) {
            uf[i] = i;
        }

        int cnt = n;
        for (int[] edge : edges) {
            if (!connect(uf, edge[0], edge[1])) {
                return false;
            }
            cnt--;
        }
        return cnt == 1;
    }

    private int getParent(int[] uf, int i) {
        while (uf[i] != i) {
            uf[i] = uf[uf[i]];
            i = uf[i];
        }
        return uf[i];
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
