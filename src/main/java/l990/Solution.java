package l990;

/**
 * Solution
 *
 * @author heshan
 * @date 2021/1/6
 */
public class Solution {

    public boolean equationsPossible(String[] equations) {
        UnionFind uf = new UnionFind(26);

        for (String eq : equations) {
            if (eq.charAt(1) == '=') {
                uf.union(
                        eq.charAt(0) - 'a',
                        eq.charAt(3) - 'a'
                );
            }
        }

        for (String eq : equations) {
            if (eq.charAt(1) == '!') {
                if (uf.isConnect(
                        eq.charAt(0) - 'a',
                        eq.charAt(3) - 'a'
                )) {
                    return false;
                }
            }
        }

        return true;
    }

    private class UnionFind {

        int[] parent;

        public UnionFind(int n) {
            this.parent = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        private int find(int x) {
            while (parent[x] != x) {
                x = parent[x];
            }

            return parent[x];
        }

        public void union(int x, int y) {
            x = find(x);
            y = find(y);

            parent[y] = x;
        }

        public boolean isConnect(int x, int y) {
            return find(x) == find(y);
        }
    }
}
