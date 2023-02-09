package leetcode.p320;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/9
 */
public class Solution {

    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();

        backtrack(word, 0, false, new StringBuilder(), res);

        return res;
    }

    private void backtrack(String word, int ind, boolean flag, StringBuilder sb, List<String> res) {
        if (ind == word.length()) {
            res.add(sb.toString());
            return;
        }

        if (!flag) {
            for (int i = word.length() - 1; i >= ind; i--) {
                int length = i - ind + 1;
                sb.append(length);
                backtrack(word, i + 1, true, sb, res);
                sb.deleteCharAt(sb.length() - 1);
                if (length >= 10) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
        sb.append(word.charAt(ind));
        backtrack(word, ind + 1, false, sb, res);
        sb.deleteCharAt(sb.length() - 1);
    }
}
