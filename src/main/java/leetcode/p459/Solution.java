package leetcode.p459;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/21
 */
public class Solution {

    public boolean repeatedSubstringPattern(String s) {
        return (s + s).indexOf(s, 1) != s.length();
    }
}
