package leetcode.p2185;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/26
 */
public class Solution {

    public int prefixCount(String[] words, String pref) {
        int res = 0;
        for (String word : words) {
            if (hasPrefix(word, pref)) {
                res++;
            }
        }
        return res;
    }

    private boolean hasPrefix(String word, String pre) {
        if (word.length() < pre.length()) {
            return false;
        }

        for (int i = 0; i < pre.length(); i++) {
            if (pre.charAt(i) != word.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
