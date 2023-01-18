package leetcode.p763;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/18
 */
public class Solution {

    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length(); ) {
            int right = map.get(s.charAt(i));

            for (int j = i; j < right; j++) {
                right = Math.max(right, map.get(s.charAt(j)));
            }

            res.add(right - i + 1);
            i = right + 1;
        }

        return res;
    }
}
