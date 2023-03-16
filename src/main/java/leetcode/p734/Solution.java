package leetcode.p734;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/16
 */
public class Solution {

    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) {
            return false;
        }

        Map<String, Set<String>> map = new HashMap<>();
        for (List<String> pair : similarPairs) {
            add(map, pair.get(0), pair.get(1));
            add(map, pair.get(1), pair.get(0));
        }

        for (int i = 0; i < sentence1.length; i++) {
            if (sentence1[i].equals(sentence2[i])) {
                continue;
            }

            if (map.containsKey(sentence1[i]) && map.get(sentence1[i]).contains(sentence2[i])) {
                continue;
            }
            return false;
        }
        return true;
    }

    private void add(Map<String, Set<String>> map, String s1, String s2) {
        Set<String> set = map.get(s1);
        if (set == null) {
            set = new HashSet<>();
            map.put(s1, set);
        }
        set.add(s2);
    }
}
