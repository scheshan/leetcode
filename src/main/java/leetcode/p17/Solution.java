package leetcode.p17;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/30
 */
public class Solution {

    private String[] dict = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }

        backtracking(digits, 0, res, new StringBuilder());

        return res;
    }

    private void backtracking(String digits, int ind, List<String> res, StringBuilder sb) {
        if (ind == digits.length()) {
            res.add(sb.toString());
            return;
        }

        String key = dict[digits.charAt(ind) - '0'];

        for (int i = 0; i < key.length(); i++) {
            sb.append(key.charAt(i));
            backtracking(digits, ind + 1, res, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
