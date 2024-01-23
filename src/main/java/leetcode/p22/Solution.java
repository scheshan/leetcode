package leetcode.p22;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/24
 */
public class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        backtracking(n, 0, res, sb);

        return res;
    }

    private void backtracking(int n, int left, List<String> res, StringBuilder sb) {
        if (sb.length() == n << 1) {
            res.add(sb.toString());
            return;
        }

        if (left < n) {
            sb.append('(');
            backtracking(n, left + 1, res, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (sb.length() - left < left) {
            sb.append(')');
            backtracking(n, left, res, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
