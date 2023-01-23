package leetcode.p1180;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/23
 */
public class Solution {

    public int countLetters(String s) {
        int res = 0;

        int l = 0;
        while (l < s.length()) {
            int r = l + 1;
            while (r < s.length() && s.charAt(r) == s.charAt(l)) {
                r++;
            }
            res += (1 + r - l) * (r - l) >> 1;
            l = r;
        }
        return res;
    }
}
