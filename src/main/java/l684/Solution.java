package l684;

/**
 * Solution
 *
 * @author heshan
 * @date 2021/1/13
 */
public class Solution {

    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length);

        for (int[] edge : edges) {
            int x = edge[0] - 1;
            int y = edge[1] - 1;

            if (uf.isConnect(x, y)) {
                if (x < y) {
                    return new int[]{x + 1, y + 1};
                } else {
                    return new int[]{y + 1, x + 1};
                }
            }

            uf.connect(x, y);
        }

        return null;
    }

    private class UnionFind {

        private int parent[];

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        private int find(int n) {
            while (parent[n] != n) {
                int tmp = parent[n];
                parent[n] = parent[parent[n]];
                n = tmp;
            }
            return n;
        }

        public boolean isConnect(int x, int y) {
            return find(x) == find(y);
        }

        public void connect(int x, int y) {
            parent[find(x)] = find(y);
        }
    }
}
