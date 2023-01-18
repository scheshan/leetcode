package leetcode.p392;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/18
 */
public class Solution {

    public boolean isSubsequence(String s, String t) {
        int l = 0;
        int r = 0;
        while (l < s.length() && r < t.length()) {
            if (s.charAt(l) == t.charAt(r)) {
                l++;
                r++;
            } else {
                r++;
            }
        }

        return l == s.length();
    }
}
