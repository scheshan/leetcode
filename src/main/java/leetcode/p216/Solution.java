package leetcode.p216;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/23
 */
public class Solution {

    public List<List<Integer>> combinationSum3(int k, int n) {
        Deque<Integer> path = new ArrayDeque<>(k);
        List<List<Integer>> res = new ArrayList<>();

        backtracking(1, k, n, res, path);

        return res;
    }

    private void backtracking(int cur, int k, int n, List<List<Integer>> res, Deque<Integer> path) {
        if (path.size() == k) {
            if (n == 0) {
                res.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = cur; i <= Math.min(n, 9 - (k - path.size()) + 1); i++) {
            path.add(i);
            backtracking(i + 1, k, n - i, res, path);
            path.removeLast();
        }
    }
}
