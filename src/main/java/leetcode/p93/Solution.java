package leetcode.p93;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/27
 */
public class Solution {

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>(4);

        backtracking(s, 0, res, path);
        return res;
    }

    private void backtracking(String s, int ind, List<String> res, List<Integer> path) {
        if (ind == s.length() || path.size() == 4) {
            if (ind == s.length() && path.size() == 4) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < path.size(); i++) {
                    if (sb.length() > 0) {
                        sb.append('.');
                    }
                    sb.append(path.get(i));
                }
                res.add(sb.toString());
            }
            return;
        }

        path.add(s.charAt(ind) - '0');
        backtracking(s, ind + 1, res, path);
        path.remove(path.size() - 1);

        if (s.charAt(ind) != '0') {
            int n = s.charAt(ind) - '0';
            for (int i = 1; i <= 2 && ind + i < s.length(); i++) {
                n = n * 10 + (s.charAt(ind + i) - '0');
                if (n > 255) {
                    continue;
                }
                path.add(n);
                backtracking(s, ind + i + 1, res, path);
                path.remove(path.size() - 1);
            }
        }
    }
}
