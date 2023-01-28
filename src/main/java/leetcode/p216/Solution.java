package leetcode.p216;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/29
 */
public class Solution {

    public List<List<Integer>> combinationSum3(int k, int n) {
        Deque<Integer> path = new ArrayDeque<>(k);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(k, n, 1, path, res);
        return res;
    }

    private void backtrack(int k, int n, int cur, Deque<Integer> path, List<List<Integer>> res) {
        if (cur > 9 || path.size() >= k || n <= 0) {
            if (path.size() == k && n == 0) {
                res.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = cur; i <= 9 && i <= n; i++) {
            path.addLast(i);
            backtrack(k, n - i, i + 1, path, res);
            path.removeLast();
        }
    }
}
