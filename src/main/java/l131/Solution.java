package l131;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/5/14
 */
public class Solution {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new LinkedList<>();
        perm(res, new LinkedList<>(), s, 0);

        return res;
    }

    private void perm(List<List<String>> res, LinkedList<String> path, String s, int i) {
        if (i == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int j = i; j < s.length(); j++) {
            if (match(s, i, j)) {
                path.addLast(s.substring(i, j + 1));

                perm(res, path, s, j + 1);

                path.removeLast();
            }
        }
    }

    private boolean match(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
