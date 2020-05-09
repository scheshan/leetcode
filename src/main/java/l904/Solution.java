package l904;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/5/9
 */
public class Solution {

    public int totalFruit(int[] tree) {
        Map<Integer, Integer> count = new HashMap<>();

        int left = 0;
        int right = 0;
        int res = 0;

        while (right < tree.length) {
            count.compute(tree[right], (key, v) -> {
                if (v == null) {
                    v = 0;
                }
                return ++v;
            });

            if (count.size() <= 2) {
                res = Math.max(res, right - left + 1);
            }

            right++;

            while (count.size() > 2) {
                int item = tree[left++];
                int c = count.compute(item, (key, v) -> --v);
                if (c == 0) {
                    count.remove(item);
                }
            }
        }
        return res;
    }
}
