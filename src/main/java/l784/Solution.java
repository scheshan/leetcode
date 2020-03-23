package l784;

import java.util.LinkedList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/24
 */
public class Solution {

    public List<String> letterCasePermutation(String S) {
        List<String> res = new LinkedList<>();

        perm(res, new StringBuilder(), S);

        return res;
    }

    private void perm(List<String> res, StringBuilder sb, String S) {
        if (sb.length() == S.length()) {
            res.add(sb.toString());
            return;
        }

        char ch = S.charAt(sb.length());

        sb.append(ch);
        perm(res, sb, S);
        sb.deleteCharAt(sb.length() - 1);

        if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
            ch ^= 32;
            sb.append(ch);
            perm(res, sb, S);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
