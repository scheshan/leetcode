package l947;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2021/1/15
 */
public class Solution {

    public int removeStones(int[][] stones) {
        UnionFind uf = new UnionFind();

        for (int[] stone : stones) {
            uf.connect(stone[0] + 10000, stone[1]);
        }

        return stones.length - uf.size();
    }

    private class UnionFind {

        private Map<Integer, Integer> parent;

        private int count;

        public UnionFind() {
            parent = new HashMap<>();
        }

        private int find(int n) {
            if (!parent.containsKey(n)) {
                parent.put(n, n);
                count++;
            }

            while (parent.get(n) != n) {
                n = parent.get(parent.get(n));
            }
            return n;
        }

        public void connect(int x, int y) {
            x = find(x);
            y = find(y);

            if (x == y) {
                return;
            }

            parent.put(x, y);
            count--;
        }

        public int size() {
            return count;
        }
    }
}
