package offer2.p085;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/27
 */
public class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        perm(n, 0, 0, new StringBuilder(n << 1), res);
        return res;
    }

    private void perm(int n, int left, int right, StringBuilder sb, List<String> res) {
        if (sb.length() == n << 1) {
            res.add(sb.toString());
        }

        if (left < n) {
            sb.append('(');
            perm(n, left + 1, right, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right < left) {
            sb.append(')');
            perm(n, left, right + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
