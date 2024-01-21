package leetcode.p17;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/21
 */
public class Solution {

    private static String[] map = {
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        if (digits == null || digits.isEmpty()) {
            return res;
        }

        char[] arr = new char[digits.length()];
        backtrack(digits, 0, arr, res);

        return res;
    }

    private void backtrack(String digits, int ind, char[] arr, List<String> res) {
        if (ind == digits.length()) {
            res.add(new String(arr));
            return;
        }

        int n = digits.charAt(ind) - '1';
        String str = map[n];

        for (int i = 0; i < str.length(); i++) {
            arr[ind] = str.charAt(i);
            backtrack(digits, ind + 1, arr, res);
        }
    }
}
