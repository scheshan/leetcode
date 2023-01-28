package leetcode.p93;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/28
 */
public class Solution {

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        perm(s, 0, new ArrayDeque<>(4), res);
        return res;
    }

    private void perm(String s, int ind, Deque<Integer> deque, List<String> res) {
        if (deque.size() == 4 || ind == s.length()) {
            if (deque.size() == 4 && ind == s.length()) {
                StringBuilder sb = new StringBuilder();
                for (int num : deque) {
                    if (sb.length() > 0) {
                        sb.append(".");
                    }
                    sb.append(num);
                }
                res.add(sb.toString());
            }
            return;
        }

        int cur = 0;
        for (int i = ind; i < ind + 3 && i < s.length(); i++) {
            if (i > ind && s.charAt(ind) == '0') {
                break;
            }

            cur = cur * 10 + s.charAt(i) - '0';
            if (cur > 255) {
                break;
            }
            deque.addLast(cur);
            perm(s, i + 1, deque, res);
            deque.removeLast();
        }
    }
}
