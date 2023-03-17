package leetcode.p408;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/17
 */
public class Solution {

    public boolean validWordAbbreviation(String word, String abbr) {
        int l = 0;
        int r = 0;

        while (r < abbr.length()) {
            if (l >= word.length()) {
                return false;
            }
            if (Character.isAlphabetic(abbr.charAt(r))) {
                if (word.charAt(l++) != abbr.charAt(r++)) {
                    return false;
                }
            } else {
                if (abbr.charAt(r) == '0') {
                    return false;
                }
                int n = 0;
                while (r < abbr.length() && Character.isDigit(abbr.charAt(r))) {
                    n = n * 10 + abbr.charAt(r) - '0';
                    r++;
                }
                l += n;
            }
        }

        return l == word.length();
    }
}
