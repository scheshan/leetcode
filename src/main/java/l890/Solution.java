package l890;

import java.util.LinkedList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/9
 */
public class Solution {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new LinkedList<>();
        for (String word : words) {
            if (match(word, pattern)) {
                res.add(word);
            }
        }

        return res;
    }

    private boolean match(String word, String pattern) {
        int[] m1 = new int[26];
        int[] m2 = new int[26];

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (m1[ch - 'a'] == 0 && m2[pattern.charAt(i) - 'a'] == 0) {
                m1[ch - 'a'] = pattern.charAt(i) - 'a' + 1;
                m2[pattern.charAt(i) - 'a'] = ch - 'a' + 1;
            } else {
                if (m1[ch - 'a'] != pattern.charAt(i) - 'a' + 1) {
                    return false;
                }
                if (m2[pattern.charAt(i) - 'a'] != ch - 'a' + 1) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        new Solution().findAndReplacePattern(new String[]{"mee", "aqq", "dkd", "ccc"}, "abb");
    }
}
