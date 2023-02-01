package leetcode.p684;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/1
 */
public class Solution {

    public int[] findRedundantConnection(int[][] edges) {
        int[] uf = new int[edges.length + 1];
        for (int i = 0; i < uf.length; i++) {
            uf[i] = i;
        }
        for (int[] edge : edges) {
            if (!connect(uf, edge[0], edge[1])) {
                return edge;
            }
        }
        return null;
    }

    private boolean connect(int[] uf, int i, int j) {
        int p1 = find(uf, i);
        int p2 = find(uf, j);
        if (p1 == p2) {
            return false;
        }
        uf[p2] = p1;
        return true;
    }

    private int find(int[] uf, int i) {
        while (i != uf[i]) {
            uf[i] = uf[uf[i]];
            i = uf[i];
        }
        return i;
    }
}
