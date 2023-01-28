package leetcode.p2255;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/28
 */
public class Solution {

    public int countPrefixes(String[] words, String s) {
        int res = 0;
        for (String word : words) {
            if (isPrefix(word, s)) {
                res++;
            }
        }
        return res;
    }

    private boolean isPrefix(String word, String s) {
        if (word.length() > s.length()) {
            return false;
        }

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
