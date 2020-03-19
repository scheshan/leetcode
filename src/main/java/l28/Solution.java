package l28;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/19
 */
public class Solution {

    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) {
            return -1;
        }

        int l = 0;
        int r = 0;

        while (l < haystack.length() && r < needle.length()) {
            if (haystack.charAt(l) == needle.charAt(r)) {
                l++;
                r++;
            } else {
                l = l - r + 1;
                r = 0;
            }
        }

        return r == needle.length() ? l - r : -1;
    }
}
