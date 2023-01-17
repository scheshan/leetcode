package leetcode.p1768;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/17
 */
public class Solution {

    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder(word1.length() + word2.length());

        int l = 0;
        int r = 0;
        while (l < word1.length() || r < word2.length()) {
            if (l < word1.length()) {
                sb.append(word1.charAt(l++));
            }
            if (r < word2.length()) {
                sb.append(word2.charAt(r++));
            }
        }

        return sb.toString();
    }
}
