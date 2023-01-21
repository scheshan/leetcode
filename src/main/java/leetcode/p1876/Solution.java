package leetcode.p1876;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/21
 */
public class Solution {

    public int countGoodSubstrings(String s) {
        int res = 0;
        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i - 2) != s.charAt(i - 1) && s.charAt(i - 1) != s.charAt(i) && s.charAt(i - 2) != s.charAt(i)) {
                res++;
            }
        }
        return res;
    }
}
