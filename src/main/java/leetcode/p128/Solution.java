package leetcode.p128;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/20
 */
public class Solution {

    public int longestConsecutive(int[] nums) {
        UF uf = new UF();
        for (int num : nums) {
            uf.add(num);

            uf.connect(num, num + 1);
            uf.connect(num, num - 1);
        }

        int res = 0;
        for (Map.Entry<Integer, Integer> entry : uf.size.entrySet()) {
            res = Math.max(res, entry.getValue());
        }

        return res;
    }

    private class UF {

        private Map<Integer, Integer> parent = new HashMap<>();

        private Map<Integer, Integer> size = new HashMap<>();

        private void add(int n) {
            if (parent.containsKey(n)) {
                return;
            }

            parent.put(n, n);
            size.put(n, 1);
        }

        private int getParent(int n) {
            while (parent.get(n) != n) {
                parent.put(n, parent.get(parent.get(n)));
                n = parent.get(n);
            }

            return n;
        }

        private void connect(int x, int y) {
            if (!parent.containsKey(x) || !parent.containsKey(y)) {
                return;
            }

            int p1 = getParent(x);
            int p2 = getParent(y);

            if (p1 != p2) {
                parent.put(p1, p2);
                size.put(p2, size.get(p2) + size.get(p1));
            }
        }
    }

    public static void main(String[] args) {
        new Solution().longestConsecutive(new int[]{1, 2, 0, 1});
    }
}
