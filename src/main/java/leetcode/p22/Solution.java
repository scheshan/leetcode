package leetcode.p22;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/2/1
 */
public class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtracking(0, 0, n, res, sb);

        return res;
    }

    private void backtracking(int left, int right, int n, List<String> res, StringBuilder sb) {
        if (sb.length() == n << 1) {
            res.add(sb.toString());
            return;
        }

        if (left < n) {
            sb.append('(');
            backtracking(left + 1, right, n, res, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (left > right) {
            sb.append(')');
            backtracking(left, right + 1, n, res, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
