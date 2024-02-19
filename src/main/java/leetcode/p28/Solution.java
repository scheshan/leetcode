package leetcode.p28;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/2/19
 */
public class Solution {

    public int strStr(String haystack, String needle) {
        int[] next = getNext(needle);

        int i = 0, j = 0;
        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else if (j > 0) {
                j = next[j - 1];
            } else {
                i++;
            }

            if (j == needle.length()) {
                return i - needle.length();
            }
        }

        return -1;
    }

    private int[] getNext(String pattern) {
        int[] next = new int[pattern.length()];
        int pre = 0, ind = 1;

        while (ind < pattern.length()) {
            if (pattern.charAt(ind) == pattern.charAt(pre)) {
                next[ind++] = ++pre;
            } else if (pre == 0) {
                ind++;
            } else {
                pre = next[pre - 1];
            }
        }

        return next;
    }
}
