package l128;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/5/13
 */
public class Solution {

    public int longestConsecutive(int[] nums) {
        Map<Integer, int[]> beginMap = new HashMap<>();
        Map<Integer, int[]> endMap = new HashMap<>();

        int res = 0;

        for (int n : nums) {
            int[] range = new int[]{n, n};
            if (beginMap.containsKey(n + 1)) {
                int[] r = beginMap.remove(n + 1);
                range[1] = r[1];
            }
            if (endMap.containsKey(n - 1)) {
                int[] r = endMap.remove(n - 1);
                range[0] = r[0];
            }

            if (beginMap.containsKey(range[0])) {
                int[] r = beginMap.get(range[0]);
                r[1] = Math.max(r[1], range[1]);
            } else {
                beginMap.put(range[0], range);
            }
            if (endMap.containsKey(range[1])) {
                int[] r = endMap.get(range[1]);
                r[0] = Math.min(r[0], range[0]);
            } else {
                endMap.put(range[1], range);
            }

            res = Math.max(res, range[1] - range[0] + 1);
        }
        return res;
    }
}
