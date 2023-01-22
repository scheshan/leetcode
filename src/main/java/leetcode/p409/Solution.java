package leetcode.p409;

import java.util.HashSet;
import java.util.Set;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/22
 */
public class Solution {

    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                set.remove(s.charAt(i));
                res += 2;
            } else {
                set.add(s.charAt(i));
            }
        }
        if (set.size() > 0) {
            res++;
        }
        return res;
    }
}
