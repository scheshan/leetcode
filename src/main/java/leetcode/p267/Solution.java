package leetcode.p267;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/9
 */
public class Solution {

    private int[] count = new int[26];

    private List<String> res = new ArrayList<>();

    public List<String> generatePalindromes(String s) {
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        if (!valid()) {
            return res;
        }
        char[] path = new char[s.length()];
        int total = (s.length() + 1) >> 1;
        backtrack(0, total, path);
        return res;
    }

    private void backtrack(int ind, int total, char[] path) {
        if (ind == total) {
            res.add(new String(path));
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] <= 0) {
                continue;
            }
            if (ind < total - 1 && count[i] < 2) {
                continue;
            }

            count[i] -= 2;
            path[ind] = (char) ('a' + i);
            path[path.length - ind - 1] = path[ind];
            backtrack(ind + 1, total, path);
            count[i] += 2;
        }
    }

    private boolean valid() {
        boolean flag = false;
        for (int i = 0; i < 26; i++) {
            if ((count[i] & 1) == 1) {
                if (flag) {
                    return false;
                }
                flag = true;
            }
        }
        return true;
    }
}
