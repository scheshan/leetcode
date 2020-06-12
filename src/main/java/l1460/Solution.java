package l1460;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/6/12
 */
public class Solution {

    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> m1 = new HashMap<>();

        for (int n : target) {
            m1.compute(n, (k, v) -> {
                if (v == null) {
                    v = 0;
                }
                return ++v;
            });
        }
        for (int n : arr) {
            if (!m1.containsKey(n)) {
                return false;
            }

            int v = m1.get(n) - 1;
            if (v == 0) {
                m1.remove(n);
            } else {
                m1.put(n, v);
            }
        }

        return true;
    }
}
