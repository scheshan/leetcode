package leetcode.p1614;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/26
 */
public class Solution {

    public int maxDepth(String s) {
        int res = 0;
        int depth = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                depth++;
                res = Math.max(res, depth);
            } else if (s.charAt(i) == ')') {
                depth--;
            }
        }
        return res;
    }
}
