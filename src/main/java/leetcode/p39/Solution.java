package leetcode.p39;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/30
 */
public class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>(candidates.length);

        backtracking(candidates, 0, target, res, path);

        return res;
    }

    private void backtracking(int[] candidates, int ind, int target, List<List<Integer>> res, Deque<Integer> path) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = ind; i < candidates.length && candidates[i] <= target; i++) {
            path.addLast(candidates[i]);
            backtracking(candidates, i, target - candidates[i], res, path);
            path.removeLast();
        }
    }
}
