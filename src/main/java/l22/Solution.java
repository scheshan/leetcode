package l22;

import java.util.LinkedList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/23
 */
public class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();

        perm(res, new StringBuilder(), 0, 0, n);

        return res;
    }

    private void perm(List<String> res, StringBuilder sb, int left, int right, int n) {
        if (left < n) {
            sb.append('(');

            perm(res, sb, left + 1, right, n);

            sb.deleteCharAt(sb.length() - 1);
        }
        if (right < left) {
            sb.append(')');

            if (sb.length() == 2 * n) {
                res.add(sb.toString());
            } else {
                perm(res, sb, left, right + 1, n);
            }

            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
