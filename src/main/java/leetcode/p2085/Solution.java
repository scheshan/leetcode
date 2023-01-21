package leetcode.p2085;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/21
 */
public class Solution {

    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> count = new HashMap<>();
        for (String str : words1) {
            if (count.containsKey(str)) {
                count.put(str, count.get(str) + 1);
            } else {
                count.put(str, 1);
            }
        }

        int res = 0;
        Map<String, Integer> count2 = new HashMap<>();
        for (String str : words2) {
            if (count.containsKey(str) && count.get(str) == 1) {
                if (count2.containsKey(str)) {
                    if (count2.get(str) == 1) {
                        res--;
                    }
                    count2.put(str, count2.get(str) + 1);
                } else {
                    count2.put(str, 1);
                    res++;
                }
            }
        }
        return res;
    }
}
