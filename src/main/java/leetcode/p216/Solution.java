package leetcode.p216;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/30
 */
public class Solution {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>(k);
        backtracking(0, n, k, res, path);

        return res;
    }

    private void backtracking(int ind, int n, int k, List<List<Integer>> res, Deque<Integer> path) {
        if (n == 0 || path.size() == k) {
            if (n == 0 && path.size() == k) {
                res.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = ind + 1; i <= 9; i++) {
            path.addLast(i);
            backtracking(i, n - i, k, res, path);
            path.removeLast();
        }
    }
}
