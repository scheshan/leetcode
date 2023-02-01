package leetcode.p389;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/1
 */
public class Solution {

    public char findTheDifference(String s, String t) {
        int n = 0;
        for (int i = 0; i < t.length(); i++) {
            n += t.charAt(i);
        }

        for (int i = 0; i < s.length(); i++) {
            n -= s.charAt(i);
        }

        return (char) n;
    }
}
