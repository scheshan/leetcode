package leetcode.p131;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/2/1
 */
public class Solution {

    public List<List<String>> partition(String s) {
        Deque<String> path = new LinkedList<>();
        List<List<String>> res = new ArrayList<>();
        backtracking(s, 0, res, path);

        return res;
    }

    private void backtracking(String s, int ind, List<List<String>> res, Deque<String> path) {
        if (ind == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = ind; i < s.length(); i++) {
            if (valid(s, ind, i)) {
                path.add(s.substring(ind, i + 1));
                backtracking(s, i + 1, res, path);
                path.removeLast();
            }
        }
    }

    private boolean valid(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}


