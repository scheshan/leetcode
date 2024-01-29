package leetcode.p58;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/29
 */
public class Solution {

    public int lengthOfLastWord(String s) {
        int r = s.length() - 1;
        while (s.charAt(r) == ' ') {
            r--;
        }

        int res = 0;
        while (r >= 0 && s.charAt(r--) != ' ') {
            res++;
        }

        return res;
    }
}
