package leetcode.p40;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/23
 */
public class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        Deque<Integer> path = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        backtracking(candidates, 0, target, res, path);

        return res;
    }

    private void backtracking(int[] candidates, int ind, int target, List<List<Integer>> res, Deque<Integer> path) {
        if (target <= 0) {
            if (target == 0) {
                res.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = ind; i < candidates.length; i++) {
            if (i > ind && candidates[i] == candidates[i - 1]) {
                continue;
            }

            path.add(candidates[i]);
            backtracking(candidates, i + 1, target - candidates[i], res, path);
            path.removeLast();
        }
    }
}
