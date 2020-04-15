package l1408;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/15
 */
public class Solution {

    public List<String> stringMatching(String[] words) {
        Set<String> res = new HashSet<>();

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j && words[i].indexOf(words[j]) > -1) {
                    res.add(words[j]);
                }
            }
        }

        return new ArrayList<>(res);
    }
}
