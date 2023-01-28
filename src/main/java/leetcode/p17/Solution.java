package leetcode.p17;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/29
 */
public class Solution {

    private char[][] map = new char[8][];

    public List<String> letterCombinations(String digits) {
        map[0] = new char[]{'a', 'b', 'c'};
        map[1] = new char[]{'d', 'e', 'f'};
        map[2] = new char[]{'g', 'h', 'i'};
        map[3] = new char[]{'j', 'k', 'l'};
        map[4] = new char[]{'m', 'n', 'o'};
        map[5] = new char[]{'p', 'q', 'r', 's'};
        map[6] = new char[]{'t', 'u', 'v'};
        map[7] = new char[]{'w', 'x', 'y', 'z'};

        char[] path = new char[digits.length()];
        List<String> res = new ArrayList<>();
        backtrack(digits, 0, path, res);
        return res;
    }

    private void backtrack(String digits, int ind, char[] path, List<String> res) {
        if (ind == digits.length()) {
            if (ind > 0) {
                res.add(new String(path));
            }
            return;
        }

        char[] chs = map[digits.charAt(ind) - '2'];
        for (char ch : chs) {
            path[ind] = ch;
            backtrack(digits, ind + 1, path, res);
        }
    }
}
