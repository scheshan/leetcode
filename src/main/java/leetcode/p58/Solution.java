package leetcode.p58;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/11/5
 */
public class Solution {

    public int lengthOfLastWord(String s) {
        int r = s.length() - 1;
        while (s.charAt(r) == ' ') {
            r--;
        }

        int l = r;
        while (l >= 0 && s.charAt(l) != ' ') {
            l--;
        }

        return r - l;
    }
}
