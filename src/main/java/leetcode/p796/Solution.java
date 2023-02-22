package leetcode.p796;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/22
 */
public class Solution {

    public boolean rotateString(String s, String goal) {
        if (s.length() > goal.length()) {
            return false;
        }

        return (s + s).contains(goal);
    }
}
