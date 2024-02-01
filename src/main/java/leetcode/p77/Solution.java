package leetcode.p77;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/2/1
 */
public class Solution {

    public List<List<Integer>> combine(int n, int k) {
        Deque<Integer> path = new ArrayDeque<>(k);
        List<List<Integer>> res = new ArrayList<>();

        backtracking(1, n, k, res, path);

        return res;
    }

    private void backtracking(int cur, int n, int k, List<List<Integer>> res, Deque<Integer> path) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = cur; i <= n; i++) {
            path.add(i);

            backtracking(i + 1, n, k, res, path);

            path.removeLast();
        }
    }
}
