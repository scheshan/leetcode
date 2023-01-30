package leetcode.p28;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/31
 */
public class Solution {

    public int strStr(String haystack, String needle) {
        int[] next = getNext(needle);

        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;

                if (j == needle.length()) {
                    return i - j + 1;
                }
            }
        }

        return -1;
    }

    private int[] getNext(String s) {
        int[] next = new int[s.length()];
        int j = 0;

        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j = j + 1;
            }
            next[i] = j;
        }
        return next;
    }
}
