package l1319;

/**
 * Solution
 *
 * @author heshan
 * @date 2021/1/23
 */
public class Solution {

    public int makeConnected(int n, int[][] connections) {
        UnionFind uf = new UnionFind(n);
        for (int[] conn : connections) {
            uf.union(conn[0], conn[1]);
        }

        return uf.duplicates >= uf.size - 1 ? uf.size - 1 : -1;
    }

    private class UnionFind {

        private int size;

        private int duplicates;

        private int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size++;
            }
        }

        private int find(int x) {
            while (parent[x] != x) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }

            return x;
        }

        public void union(int x, int y) {
            x = find(x);
            y = find(y);

            if (x == y) {
                duplicates++;
                return;
            }

            parent[x] = y;
            size--;
        }
    }
}
