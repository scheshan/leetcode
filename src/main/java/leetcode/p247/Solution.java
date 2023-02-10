package leetcode.p247;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/10
 */
public class Solution {

    private char[][] pairs = new char[][]{
            {'0', '0'},
            {'1', '1'},
            {'6', '9'},
            {'8', '8'},
            {'9', '6'}
    };

    public List<String> findStrobogrammatic(int n) {
        char[] path = new char[n];
        List<String> res = new ArrayList<>();
        backtrack(path, 0, res);
        return res;
    }

    private void backtrack(char[] path, int ind, List<String> res) {
        if (ind == (path.length + 1) >> 1) {
            res.add(new String(path));
            return;
        }

        for (char[] pair : pairs) {
            if (ind == 0 && path.length > 1 && pair[0] == '0') {
                continue;
            }

            path[ind] = pair[0];
            if (path.length - ind - 1 != ind) {
                path[path.length - ind - 1] = pair[1];
            } else if (pair[0] != pair[1]) {
                continue;
            }
            backtrack(path, ind + 1, res);
        }
    }
}
