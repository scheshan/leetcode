package l17;

import java.util.LinkedList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/25
 */
public class Solution {

    public List<String> letterCombinations(String digits) {
        char[][] chars = new char[10][];
        chars[2] = new char[]{'a', 'b', 'c'};
        chars[3] = new char[]{'d', 'e', 'f'};
        chars[4] = new char[]{'g', 'h', 'i'};
        chars[5] = new char[]{'j', 'k', 'l'};
        chars[6] = new char[]{'m', 'n', 'o'};
        chars[7] = new char[]{'p', 'q', 'r', 's'};
        chars[8] = new char[]{'t', 'u', 'v'};
        chars[9] = new char[]{'w', 'x', 'y', 'z'};

        List<String> res = new LinkedList<>();
        perm(res, chars, new StringBuilder(), digits, 0);

        return res;
    }

    private void perm(List<String> res, char[][] chars, StringBuilder sb, String digits, int i) {
        if (i == digits.length()) {
            if (i > 0) {
                res.add(sb.toString());
            }
            return;
        }

        char[] arr = chars[digits.charAt(i) - '0'];
        for (int j = 0; j < arr.length; j++) {
            sb.append(arr[j]);

            perm(res, chars, sb, digits, i + 1);

            sb.deleteCharAt(i);
        }
    }
}
