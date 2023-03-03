package leetcode.p647;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/3
 */
public class Solution {

    public int countSubstrings(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += count(s, i, i);
            res += count(s, i - 1, i);
        }
        return res;
    }

    private int count(String s, int l, int r) {
        int res = 0;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            res++;
            l--;
            r++;
        }
        return res;
    }
}
