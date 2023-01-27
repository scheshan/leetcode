package leetcode.p2124;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/27
 */
public class Solution {

    public boolean checkString(String s) {
        boolean meetB = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                if (meetB) {
                    return false;
                }
            } else {
                meetB = true;
            }
        }
        return true;
    }
}
