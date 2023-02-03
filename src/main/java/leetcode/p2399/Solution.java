package leetcode.p2399;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/3
 */
public class Solution {

    public boolean checkDistances(String s, int[] distance) {
        for (int i = 0; i < s.length(); i++) {
            int d = distance[s.charAt(i) - 'a'] + 1;
            if ((i - d >= 0 && s.charAt(i - d) == s.charAt(i)) || (i + d < s.length() && s.charAt(i + d) == s.charAt(i))) {
                continue;
            }
            return false;
        }
        return true;
    }
}
