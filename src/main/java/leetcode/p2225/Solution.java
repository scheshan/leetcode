package leetcode.p2225;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/2
 */
public class Solution {

    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] match : matches) {
            if (!map.containsKey(match[0])) {
                map.put(match[0], 0);
            }
            int c = map.getOrDefault(match[1], 0);
            map.put(match[1], c + 1);
        }

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 0) {
                l1.add(entry.getKey());
            } else if (entry.getValue() == 1) {
                l2.add(entry.getKey());
            }
        }
        l1.sort(Integer::compareTo);
        l2.sort(Integer::compareTo);

        res.add(l1);
        res.add(l2);
        return res;
    }
}
