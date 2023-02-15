package leetcode.p819;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/15
 */
public class Solution {

    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> set = new HashSet<>();
        for (String str : banned) {
            set.add(str);
        }

        Map<String, Integer> count = new HashMap<>();
        int max = 0;
        String res = null;
        int ind = 0;
        while (ind < paragraph.length()) {
            int pre = ind;
            while (ind < paragraph.length() && isAlphabet(paragraph, ind)) {
                ind++;
            }

            if (pre != ind) {
                String word = paragraph.substring(pre, ind).toLowerCase();
                if (!set.contains(word)) {
                    count.put(word, count.getOrDefault(word, 0) + 1);
                    if (count.get(word) > max) {
                        max = count.get(word);
                        res = word;
                    }
                }
            }

            while (ind < paragraph.length() && !isAlphabet(paragraph, ind)) {
                ind++;
            }
        }
        return res;
    }

    private boolean isAlphabet(String str, int ind) {
        char ch = str.charAt(ind);
        if (ch >= 'a' && ch <= 'z') {
            return true;
        } else if (ch >= 'A' && ch <= 'Z') {
            return true;
        }
        return false;
    }
}
