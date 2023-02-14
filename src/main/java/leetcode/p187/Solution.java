package leetcode.p187;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/14
 */
public class Solution {

    public List<String> findRepeatedDnaSequences(String s) {
        Map<Integer, Integer> count = new HashMap<>();
        List<String> res = new ArrayList<>();
        if (s.length() <= 10) {
            return res;
        }

        int mask = 0b00111111111111111111111111111111;
        int hash = 0;
        for (int i = 0; i < 10; i++) {
            hash <<= 3;
            hash |= toBit(s.charAt(i));
        }
        count.put(hash, 1);

        for (int i = 10; i < s.length(); i++) {
            hash <<= 3;
            hash = hash & mask;
            hash |= toBit(s.charAt(i));

            if (count.containsKey(hash) && count.get(hash) == 1) {
                res.add(s.substring(i - 10 + 1, i + 1));
            }
            count.put(hash, count.getOrDefault(hash, 0) + 1);
        }
        return res;
    }

    private int toBit(char ch) {
        switch (ch) {
            case 'A':
                return 1;
            case 'C':
                return 2;
            case 'T':
                return 3;
            default:
                return 4;
        }
    }
}
