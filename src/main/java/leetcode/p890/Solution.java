package leetcode.p890;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/29
 */
public class Solution {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();

        Map<Character, Character> m1 = new HashMap<>();
        Map<Character, Character> m2 = new HashMap<>();
        for (String word : words) {
            m1.clear();
            m2.clear();
            boolean match = true;

            for (int i = 0; i < word.length(); i++) {
                char ch1 = word.charAt(i);
                char ch2 = pattern.charAt(i);

                if (m1.containsKey(ch1) && m2.containsKey(ch2)) {
                    if (m1.get(ch1) != ch2 || m2.get(ch2) != ch1) {
                        match = false;
                    }
                } else if (!m1.containsKey(ch1) && !m2.containsKey(ch2)) {
                    m1.put(ch1, ch2);
                    m2.put(ch2, ch1);
                } else {
                    match = false;
                }
                if (!match) {
                    break;
                }
            }

            if (match) {
                res.add(word);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution().findAndReplacePattern(new String[]{"mee"}, "abb");
    }
}
