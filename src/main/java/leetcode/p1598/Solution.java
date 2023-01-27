package leetcode.p1598;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/27
 */
public class Solution {

    public int minOperations(String[] logs) {
        int depth = 0;

        for (String log : logs) {
            if (log.startsWith("..")) {
                depth = Math.max(depth - 1, 0);
            } else if (log.startsWith(".")) {

            } else {
                depth++;
            }
        }
        return depth;
    }
}
