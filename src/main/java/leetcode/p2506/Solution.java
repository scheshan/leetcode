package leetcode.p2506;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/30
 */
public class Solution {

    public int similarPairs(String[] words) {
        Map<Integer, Integer> map = new HashMap<>();

        for (String word : words) {
            int n = 0;
            for (int i = 0; i < word.length(); i++) {
                n |= 1 << (word.charAt(i) - 'a');
            }
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                res += (entry.getValue() * (entry.getValue() - 1)) / 2;
            }
        }
        return res;
    }
}
