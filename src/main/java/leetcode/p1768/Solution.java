package leetcode.p1768;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/28
 */
public class Solution {

    public String mergeAlternately(String word1, String word2) {
        char[] res = new char[word1.length() + word2.length()];

        int l = 0, r = 0, ind = 0;
        while (l < word1.length() || r < word2.length()) {
            if (l < word1.length()) {
                res[ind++] = word1.charAt(l++);
            }
            if (r < word2.length()) {
                res[ind++] = word2.charAt(r++);
            }
        }

        return new String(res);
    }
}
