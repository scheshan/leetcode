package leetcode.p131;

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

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        perm(s, 0, s.length(), new ArrayDeque<>(s.length()), res);
        return res;
    }

    private void perm(String s, int start, int end, Deque<int[]> path, List<List<String>> res) {
        if (start == end) {
            List<String> list = new ArrayList<>(path.size());
            for (int[] arr : path) {
                list.add(s.substring(arr[0], arr[1]));
            }
            res.add(list);
            return;
        }

        for (int i = start; i < end; i++) {
            if (isValid(s, start, i + 1)) {
                path.addLast(new int[]{start, i + 1});
                perm(s, i + 1, end, path, res);
                path.removeLast();
            }
        }
    }

    private boolean isValid(String s, int start, int end) {
        int l = start;
        int r = end - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }
}
